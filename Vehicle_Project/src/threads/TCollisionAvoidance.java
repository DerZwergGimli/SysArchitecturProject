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

import objects.LidarSensor;
import threads.handler.MissCollisonAvoidance;
import threads.handler.OverrunCollisonAvoidance;
import threads.interruptible.InterruptableCollisionAvoidance;

public class TCollisionAvoidance extends RealtimeThread {

	volatile OverrunCollisonAvoidance overrunHandler;
	MissCollisonAvoidance missHandler;
	private volatile Logger logger;
	ArrayBlockingQueue<LidarSensor> lidarSensorQueue;

	public TCollisionAvoidance(Logger logger, MissCollisonAvoidance missHandler,
			ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.setName("TCollisionAvoidance");
		this.logger = logger;
		this.missHandler = missHandler;
		this.lidarSensorQueue = lidarSensorQueue;

		overrunHandler = new OverrunCollisonAvoidance(logger);

		overrunHandler.setThread(this);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(250, 0),
				new RelativeTime(100, 0), new RelativeTime(200, 0), overrunHandler, missHandler);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	public void setOverrunLogger(Logger logger) {
		this.logger = logger;
		overrunHandler.setLogger(logger);
	}

	@Override
	public void run() {
		try {
			logger.info("Creating InterruptableCollisionAvoidance");
			AsynchronouslyInterruptedException asInterruptExeption = new AsynchronouslyInterruptedException();
			missHandler.setInterruptExeption(asInterruptExeption);
			InterruptableCollisionAvoidance inCollisionAvoidance = new InterruptableCollisionAvoidance(logger,
					lidarSensorQueue);
			asInterruptExeption.doInterruptible(inCollisionAvoidance);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating Interruptable", e);
		}
	}

}
