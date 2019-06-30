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
		logger.log(Level.WARNING, "Lidar-Data-Collection thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {

		while (management.isLidarDataCollectionThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			IStopWatch stopWatch = new StopWatch();
			stopWatch.init();
			stopWatch.start();
			int[] lidarData = readFromSensor();
			stopWatch.stopAndCalulate();
			sendDataToQueue(lidarData, stopWatch);
		}

	}

	private int[] readFromSensor() {
		if (lidarController.isEnabled()) {
			int lidarValues[] = lidarController.scan();
			if (lidarValues.length != 0) {
//				for (int i : lidarValues) {
//					System.out.print(i + ", ");
				return lidarValues;
//				}
//				System.out.println("(" + lidarValues.length + ")");
			} else {
				logger.log(Level.WARNING, "Error while reading lidar sensor values");
			}
			return new int[0];
		} else {
			logger.info("Lidar sensor disabled but thread started!");
		}
		return new int[0];

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
			LidarSensor lidarSensor = new LidarSensor();
			lidarSensor.setRandomDistances();
			logger.log(Level.INFO, "Generated RANDOM lidarValues");
			IQLidarBuffer lidarObject = new QLidarBuffer(lidarSensor, stopWatch);
			if (!qlidarBuffer.offer(lidarObject)) {
				logger.log(Level.WARNING, "Could not write into queue");
			}
		}

	}

}
