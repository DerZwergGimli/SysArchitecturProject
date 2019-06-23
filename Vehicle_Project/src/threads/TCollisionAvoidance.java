package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

import gpioInterface.lidar.ILidarSensor;
import management.IManagementControl;
import threads.handler.MissCollisonAvoidance;
import threads.handler.OverrunCollisonAvoidance;
import threads.interruptible.InterruptibleCollisionAvoidance;
import threads.queue.IQCollisonBuffer;

/**
 * This is a RealtimeThread used for checking periodically for a
 * collision/objects
 * 
 * @author yannick
 *
 */
public class TCollisionAvoidance extends RealtimeThread implements IHandableThread {
	private volatile Logger logger;
	private IManagementControl management;
	private volatile OverrunCollisonAvoidance overrunHandlerCollisionAvoidance;
	private MissCollisonAvoidance missHandlerCollisionAvoidance;

	private ArrayBlockingQueue<ILidarSensor> qLidarSensor;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;

	/**
	 * Constructor for the CollisionAvoidance RealtimeThread
	 * 
	 * @param logger
	 * @param management
	 * @param missHandlerCollisionAvoidance
	 * @param qLidarSensor
	 * @param qCollisonControl
	 */
	public TCollisionAvoidance(Logger logger, IManagementControl management,
			MissCollisonAvoidance missHandlerCollisionAvoidance, ArrayBlockingQueue<ILidarSensor> qLidarSensor,
			ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
		this.setName("TCollisionAvoidance");
		this.logger = logger;
		this.management = management;
		this.missHandlerCollisionAvoidance = missHandlerCollisionAvoidance;
		// this.lidarSensorQueue = lidarSensorQueue;
		this.qLidarSensor = qLidarSensor;
		this.qCollisonControl = qCollisonControl;

		overrunHandlerCollisionAvoidance = new OverrunCollisonAvoidance(logger);
		overrunHandlerCollisionAvoidance.setThread(this);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(250, 0),
				new RelativeTime(100, 0), new RelativeTime(200, 0), this.overrunHandlerCollisionAvoidance,
				this.missHandlerCollisionAvoidance);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	@Override
	public void setOverrunLogger(Logger logger) {
		this.logger = logger;
		overrunHandlerCollisionAvoidance.setLogger(logger);
	}

	@Override
	public void run() {
		try {
			logger.info("Creating InterruptableCollisionAvoidance");
			AsynchronouslyInterruptedException asInterruptExeption = new AsynchronouslyInterruptedException();
			missHandlerCollisionAvoidance.setInterruptExeption(asInterruptExeption);
			InterruptibleCollisionAvoidance inCollisionAvoidance = new InterruptibleCollisionAvoidance(logger,
					management, qLidarSensor, qCollisonControl);
			asInterruptExeption.doInterruptible(inCollisionAvoidance);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating Interruptable", e);
		}
	}

}
