package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import objects.ManagementControl;

public class InterruptableCollisionAvoidance implements Interruptible {

	private Logger logger;
	private ManagementControl management;
	private ArrayBlockingQueue<LidarSensor> lidarSensorQueue;

	public InterruptableCollisionAvoidance(Logger logger, ManagementControl managemnt,
			ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.logger = logger;
		this.management = managemnt;
		this.lidarSensorQueue = lidarSensorQueue;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.SEVERE, "CollisonAvoidance was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		int bound = 0;
		double f = 0;
		int ct = 0;
		while (management.isCollisonAvoidanceThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			LidarSensor lidarSensor = new LidarSensor();
			lidarSensor.setRandomDistances();
			lidarSensorQueue.offer(lidarSensor);

			if (++ct > 2000)
				return;
			for (f = 0.0; f < bound; f += 1.0)
				;
			bound += 100000;
			System.out.println("DONG! " + bound);

		}

		logger.log(Level.WARNING, "CollisionAvoidance was exited!");
//		while (true) {
//			do {
//								try {
//					Thread.sleep(1);
//				} catch (Exception ie) {
//				}
//			} while (RealtimeThread.waitForNextPeriod());
//			System.out.println("RESETTING BOUND..");
//			bound -= 150000;
//
//			while (!RealtimeThread.waitForNextPeriod()) {
//				System.out.println(".");
//			}
//			System.out.println();
//
//		}

	}

}
