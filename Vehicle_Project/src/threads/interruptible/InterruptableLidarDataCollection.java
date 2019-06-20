package threads.interruptible;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;

import management.IManagementControl;
import management.ManagementLidar;

public class InterruptableLidarDataCollection implements Interruptible {
	private volatile Logger logger;
	private volatile IManagementControl management;
	private ManagementLidar lidarManagement;

	public InterruptableLidarDataCollection(Logger logger, IManagementControl management) {
		this.logger = logger;
		this.management = management;
	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "Lidar-Data-Collection thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		lidarManagement = new ManagementLidar();
		if (lidarManagement.isEnabled()) {
			lidarManagement.init();
			lidarManagement.startRotation();

			while (management.isLidarDataCollectionThreadRunnable()) {
				int lidarValues[] = lidarManagement.scan();
				if (lidarValues.length != 0) {
					for (int i : lidarValues) {
						System.out.print(i + ", ");
					}
					System.out.println("(" + lidarValues.length + ")");
				} else {
					logger.log(Level.WARNING, "Error while reading lidar sensor values");
				}

			}
			lidarManagement.stopRotation();
		}

	}

}
