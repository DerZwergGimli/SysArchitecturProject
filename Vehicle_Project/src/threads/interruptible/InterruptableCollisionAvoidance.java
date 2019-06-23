package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import gpioInterface.lidar.ILidarSensor;
import gpioInterface.lidar.LidarSensor;
import management.IManagementControl;
import threads.queue.IQCollisonBuffer;
import threads.queue.QCollisonBuffer;
import timing.IStopWatch;
import timing.StopWatch;

public class InterruptableCollisionAvoidance implements Interruptible {

	private Logger logger;
	private IManagementControl management;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;
	private ArrayBlockingQueue<ILidarSensor> qLidarSensor;

	public InterruptableCollisionAvoidance(Logger logger, IManagementControl managemnt,
			ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
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
		IStopWatch stopWatchcurrent = new StopWatch();
		IStopWatch stopWatchOld = new StopWatch();
		stopWatchOld.init();

		while (management.isCollisonAvoidanceThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			stopWatchcurrent.start();

			ILidarSensor lidarSensor = new LidarSensor();
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

	private void sendInQueue(ILidarSensor lidarSensor, IStopWatch stopWatch) {
		IQCollisonBuffer qCollisonControlObject = new QCollisonBuffer(lidarSensor, stopWatch);
		qCollisonControl.offer(qCollisonControlObject);

	}

}
