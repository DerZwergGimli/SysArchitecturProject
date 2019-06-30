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
import management.IManagementControl;
import threads.queue.IQCollisonBuffer;
import threads.queue.IQLidarBuffer;
import threads.queue.QCollisonBuffer;
import threads.queue.QLidarBuffer;
import timing.IStopWatch;

/**
 * This is a Interruptible for the CollisionAvoidance-Thread
 * 
 * @author yannick
 *
 */
public class InterruptibleCollisionAvoidance implements Interruptible {

	private Logger logger;
	private IManagementControl management;
	private ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;

	/**
	 * This is the constructor for a Interruptible for a CollisionAvoidance-Thread
	 * 
	 * @param logger
	 * @param managemnt
	 * @param qLidarBuffer
	 * @param qCollisonControl
	 */
	public InterruptibleCollisionAvoidance(Logger logger, IManagementControl managemnt,
			ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer, ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
		this.logger = logger;
		this.management = managemnt;
		this.qLidarBuffer = qLidarBuffer;
		this.qCollisonControl = qCollisonControl;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.SEVERE, "CollisonAvoidance was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {

		while (management.isCollisonAvoidanceThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
			readFromQueue();
		}
		logger.log(Level.WARNING, "CollisionAvoidance was exited!");
	}

	private void readFromQueue() {
		QLidarBuffer lidarBuffer = null;
		try {
			lidarBuffer = (QLidarBuffer) qLidarBuffer.poll(10, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Failed to read from queue - lidrSensor!", e);
		}
		if (lidarBuffer != null) {
			CollisionAvoidance collisionAvoidance = new CollisionAvoidance(lidarBuffer.getLidarSensor(), logger);
			collisionAvoidance.checkAllSections();
			sendInQueue(lidarBuffer.getLidarSensor(), collisionAvoidance, lidarBuffer.getStopWatch());
		} else {
			logger.log(Level.INFO, "Queue was empty does nothing in here");
		}
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
