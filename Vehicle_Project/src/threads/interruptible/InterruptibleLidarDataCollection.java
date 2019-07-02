package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import gpioInterface.lidar.ILidarInterface;
import gpioInterface.lidar.LidarSensor;
import management.IManagementControl;
import threads.queue.IQLidarBuffer;
import threads.queue.QLidarBuffer;
import timing.IStopWatch;
import timing.StopWatch;

/**
 * This is a Interruptible for the LidarDataCollection-Thread
 * 
 * @author yannick
 *
 */
public class InterruptibleLidarDataCollection implements Interruptible {
	private Logger logger;
	private IManagementControl management;
	private ILidarInterface lidarController;
	private ArrayBlockingQueue<IQLidarBuffer> qlidarBuffer;

	public InterruptibleLidarDataCollection(Logger logger, IManagementControl management,
			ILidarInterface lidarController, ArrayBlockingQueue<IQLidarBuffer> qlidarBuffer) {
		this.logger = logger;
		this.management = management;
		this.lidarController = lidarController;
		this.qlidarBuffer = qlidarBuffer;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		if (lidarController.isEnabled()) {
			lidarController.stopRotation();
		}

		logger.log(Level.SEVERE, "Lidar-Data-Collection thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		if (lidarController.isEnabled()) {
			lidarController.init();
			lidarController.startRotation();
		}

		int bound = 0;
		double f = 0;
		int ct = 0;
		while (management.isLidarDataCollectionThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			IStopWatch stopWatch = new StopWatch();
			stopWatch.init();
			stopWatch.start();

			int[] lidarData = readFromSensor();

			stopWatch.stopAndCalulate();

			sendDataToQueue(lidarData, stopWatch);

			if (++ct > 2000)
				return;
			for (f = 0.0; f < bound; f += 1.0)
				;
			bound += 100000;
			System.out.println("DING! " + bound);
		}

	}

	private int[] readFromSensor() {
		if (lidarController.isEnabled()) {
			int lidarValues[] = lidarController.scan();
			if (lidarValues.length != 0) {
				return lidarValues;
			} else {
				logger.log(Level.WARNING, "Lidar distance array is zero.");
			}
			return new int[0];
		} else {

			logger.info("Lidar sensor disabled but thread started!");
			logger.info("!!--Generating random lidar values--!! ");

			return lidarController.generateRandomDistances();
		}
		// return new int[0];

	}

	private void sendDataToQueue(int[] lidarDistances, IStopWatch stopWatch) {
		if (lidarDistances.length != 0) {

			LidarSensor lidarSensor = new LidarSensor();
			lidarSensor.setDistances(lidarDistances);

			IQLidarBuffer lidarObject = new QLidarBuffer(lidarSensor, stopWatch);
			if (!qlidarBuffer.offer(lidarObject)) {
				logger.log(Level.WARNING, "Could not write into queue");
			}
		} else {
			logger.log(Level.INFO, "No values were genertaed and send to QUEUE by lidarSensorThread");
//			LidarSensor lidarSensor = new LidarSensor();
//			lidarSensor.setRandomDistances();
//			IQLidarBuffer lidarObject = new QLidarBuffer(lidarSensor, stopWatch);
//			if (!qlidarBuffer.offer(lidarObject)) {
//				logger.log(Level.WARNING, "Could not write into queue");
//			}
		}

	}

}
