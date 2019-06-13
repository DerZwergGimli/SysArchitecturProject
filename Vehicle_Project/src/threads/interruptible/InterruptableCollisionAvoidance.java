package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;

public class InterruptableCollisionAvoidance implements Interruptible {

	private Logger logger;
	private ArrayBlockingQueue<LidarSensor> lidarSensorQueue;

	public InterruptableCollisionAvoidance(Logger logger, ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.logger = logger;
		this.lidarSensorQueue = lidarSensorQueue;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "CollisonAvoidance was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		int bound = 0;
		double f = 0;
		int ct = 0;
		RealtimeThread realtimeThread = RealtimeThread.currentRealtimeThread();

		while (true) {
			do {
				LidarSensor lidarSensor = new LidarSensor();
				lidarSensor.setRandomDistances();
				lidarSensorQueue.offer(lidarSensor);

				if (++ct > 2000)
					return;
				for (f = 0.0; f < bound; f += 1.0)
					;
				bound += 100000;
				System.out.println("Ding! " + bound);
				try {
					Thread.sleep(1);
				} catch (Exception ie) {
				}
			} while (realtimeThread.waitForNextPeriod());
			System.out.println("RESETTING BOUND..");
			bound -= 150000;

			while (!realtimeThread.waitForNextPeriod()) {
				System.out.println(".");
			}
			System.out.println();

		}

	}

}
