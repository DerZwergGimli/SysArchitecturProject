package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;

public class InterruptableCollisionAvoidance implements Interruptible {

	ArrayBlockingQueue<LidarSensor> lidarSensorQueue;

	public InterruptableCollisionAvoidance(ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.lidarSensorQueue = lidarSensorQueue;
	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		System.out.println("Overrun of Thread detected -- do something here");

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
