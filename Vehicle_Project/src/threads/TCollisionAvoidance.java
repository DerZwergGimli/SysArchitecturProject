package threads;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
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

import management.IManagementControl;
import threads.handler.MissCollisonAvoidance;
import threads.handler.OverrunCollisonAvoidance;
import threads.interruptible.InterruptibleCollisionAvoidance;
import threads.queue.IQCollisonBuffer;
import threads.queue.IQLidarBuffer;

/**
 * This is a RealtimeThread used for checking periodically for a
 * collision/objects
 * 
 * @author yannick
 *
 */
public class TCollisionAvoidance extends RealtimeThread implements IHandableThread {
	private static int periode;
	private static int cost;
	private static int deadline;

	private volatile Logger logger;
	private IManagementControl management;
	private volatile OverrunCollisonAvoidance overrunHandlerCollisionAvoidance;
	private MissCollisonAvoidance missHandlerCollisionAvoidance;

	private ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer;
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
			MissCollisonAvoidance missHandlerCollisionAvoidance, ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer,
			ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
		this.setName("TCollisionAvoidance");
		this.logger = logger;
		this.management = management;
		this.missHandlerCollisionAvoidance = missHandlerCollisionAvoidance;
		this.qLidarBuffer = qLidarBuffer;
		this.qCollisonControl = qCollisonControl;

		readPropertiesFile();

		overrunHandlerCollisionAvoidance = new OverrunCollisonAvoidance(logger);
		overrunHandlerCollisionAvoidance.setThread(this);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(periode, 0),
				new RelativeTime(cost, 0), new RelativeTime(deadline, 0), this.overrunHandlerCollisionAvoidance,
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
			AsynchronouslyInterruptedException asInterruptedExeption = new AsynchronouslyInterruptedException();
			missHandlerCollisionAvoidance.setInterruptExeption(asInterruptedExeption);
			InterruptibleCollisionAvoidance inCollisionAvoidance = new InterruptibleCollisionAvoidance(logger,
					management, qLidarBuffer, qCollisonControl);
			asInterruptedExeption.doInterruptible(inCollisionAvoidance);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating Interruptable", e);
		}
	}

	private static void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config_vehicle.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			periode = Integer.valueOf(properties.getProperty("collisonAvoidance.periode"));
			cost = Integer.valueOf(properties.getProperty("collisonAvoidance.cost"));
			deadline = Integer.valueOf(properties.getProperty("collisonAvoidance.deadline"));

		} catch (Exception ex) {
			System.out.println("Error while trying to read config for Logger!!! ");

		}
	}
}
