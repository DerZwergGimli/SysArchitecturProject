package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import gpioInterface.lidar.ILidarInterface;
import gpioInterface.lidar.ILidarSensor;
import gpioInterface.lidar.LidarSensor;
import management.IManagementControl;

public class InterruptableLidarDataCollection implements Interruptible {
	private Logger logger;
	private IManagementControl management;
	private ILidarInterface lidarController;
	private ArrayBlockingQueue<ILidarSensor> qLidarSensor;

	public InterruptableLidarDataCollection(Logger logger, IManagementControl management,
			ILidarInterface lidarController, ArrayBlockingQueue<ILidarSensor> qLidarSensor) {
		this.logger = logger;
		this.management = management;
		this.lidarController = lidarController;
		this.qLidarSensor = qLidarSensor;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "Lidar-Data-Collection thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {

		while (management.isLidarDataCollectionThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			sendDataToQueue(readFromSensor());
		}

	}

	private int[] readFromSensor() {
		if (lidarController.isEnabled()) {
			int lidarValues[] = lidarController.scan();
			if (lidarValues.length != 0) {
				for (int i : lidarValues) {
					System.out.print(i + ", ");
					return lidarValues;
				}
				System.out.println("(" + lidarValues.length + ")");
			} else {
				logger.log(Level.WARNING, "Error while reading lidar sensor values");
			}
			return new int[0];
		} else {
			logger.info("Lidar sensor disabled but thread started!");
		}
		return new int[0];

	}

	private void sendDataToQueue(int[] lidarDistances) {
		if (lidarDistances.length != 0) {

			LidarSensor lidarSensor = new LidarSensor();
			lidarSensor.setDistances(lidarDistances);

			if (!qLidarSensor.offer(lidarSensor)) {
				logger.log(Level.WARNING, "Could not write into queue");
			}
		}

	}

}
