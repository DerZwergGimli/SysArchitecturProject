package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import objects.ManagementControl;
import objects.QCollisonControl;
import objects.StopWatch;

public class InterruptableCollisionAvoidance implements Interruptible {

	private Logger logger;
	private ManagementControl management;
	private ArrayBlockingQueue<QCollisonControl> qCollisonControl;

	public InterruptableCollisionAvoidance(Logger logger, ManagementControl managemnt,
			ArrayBlockingQueue<QCollisonControl> qCollisonControl) {
		this.logger = logger;
		this.management = managemnt;
		this.qCollisonControl = qCollisonControl;

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
		StopWatch stopWatchcurrent = new StopWatch();
		StopWatch stopWatchOld = new StopWatch();
		stopWatchOld.init();

		while (management.isCollisonAvoidanceThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			stopWatchcurrent.start();

			LidarSensor lidarSensor = new LidarSensor();
			lidarSensor.setRandomDistances();

			sendInQueue(lidarSensor, stopWatchOld);

			if (++ct > 2000)
				return;
			for (f = 0.0; f < bound; f += 1.0)
				;
			bound += 100000;
			System.out.println("DONG! " + bound);

			stopWatchcurrent.stopAndCalulate();
			stopWatchOld = stopWatchcurrent;
		}
		logger.log(Level.WARNING, "CollisionAvoidance was exited!");
	}

	private void sendInQueue(LidarSensor lidarSensor, StopWatch stopWatch) {
		QCollisonControl qCollisonControlObject = new QCollisonControl(lidarSensor, stopWatch);
		qCollisonControl.offer(qCollisonControlObject);

	}

}
