package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import collisonAvoidance.CollisionAvoidance;
import collisonAvoidance.ICollisonAvoidance;
import gpioInterface.lidar.ILidarSensor;
import gpioInterface.lidar.LidarSensor;
import management.IManagementControl;
import threads.queue.IQCollisonBuffer;
import threads.queue.QCollisonBuffer;
import timing.IStopWatch;
import timing.StopWatch;

/**
 * This is a Interruptible for the CollisionAvoidance-Thread
 * 
 * @author yannick
 *
 */
public class InterruptibleCollisionAvoidance implements Interruptible {

	private Logger logger;
	private IManagementControl management;
	private ArrayBlockingQueue<ILidarSensor> qLidarSensor;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;

	/**
	 * This is the constructor for a Interruptible for a CollisionAvoidance-Thread
	 * 
	 * @param logger
	 * @param managemnt
	 * @param qLidarSensor
	 * @param qCollisonControl
	 */
	public InterruptibleCollisionAvoidance(Logger logger, IManagementControl managemnt,
			ArrayBlockingQueue<ILidarSensor> qLidarSensor, ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
		this.logger = logger;
		this.management = managemnt;
		this.qLidarSensor = qLidarSensor;
		this.qCollisonControl = qCollisonControl;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.SEVERE, "CollisonAvoidance was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {

		IStopWatch stopWatchcurrent = new StopWatch();
		IStopWatch stopWatchOld = new StopWatch();
		stopWatchOld.init();

		while (management.isCollisonAvoidanceThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			stopWatchcurrent.start();

			LidarSensor lidarSensor = null;
			try {
				lidarSensor = (LidarSensor) qLidarSensor.poll(10, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				logger.log(Level.WARNING, "Failed to read from queue - lidrSensor!", e);
			}

			if (lidarSensor != null) {
				CollisionAvoidance collisionAvoidance = new CollisionAvoidance(lidarSensor);
				collisionAvoidance.checkAllSections();
				sendInQueue(lidarSensor, collisionAvoidance, stopWatchOld);
			} else {
				logger.log(Level.WARNING, "Queue was empty does nothing in here");
			}

			stopWatchcurrent.stopAndCalulate();
			stopWatchOld = stopWatchcurrent;
		}
		logger.log(Level.WARNING, "CollisionAvoidance was exited!");
	}

	private void sendInQueue(ILidarSensor lidarSensor, ICollisonAvoidance collisionAvoidance, IStopWatch stopWatch) {
		IQCollisonBuffer qCollisonControlObject = new QCollisonBuffer(lidarSensor, collisionAvoidance, stopWatch);
		qCollisonControl.offer(qCollisonControlObject);

	}

	private void generateOverun() {
		int bound = 0;
		double f = 0;
		int ct = 0;

		if (++ct > 2000)
			return;
		for (f = 0.0; f < bound; f += 1.0)
			;
		bound += 100000;
		System.out.println("DONG! " + bound);

	}

}
