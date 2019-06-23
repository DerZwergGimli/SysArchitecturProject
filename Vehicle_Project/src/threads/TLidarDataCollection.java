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

import gpioInterface.lidar.ILidarInterface;
import gpioInterface.lidar.ILidarSensor;
import management.IManagementControl;
import threads.handler.MissLidarDataCollection;
import threads.handler.OverrunLidarDataCollection;
import threads.interruptible.InterruptibleLidarDataCollection;

/**
 * This RealtimeThread is used to read the values periodically form a
 * lidar-Sensor
 * 
 * @author yannick
 *
 */
public class TLidarDataCollection extends RealtimeThread implements IHandableThread {
	private Logger logger;
	private IManagementControl management;
	private ArrayBlockingQueue<ILidarSensor> qLidarSensor;
	private ILidarInterface lidarController;

	private volatile OverrunLidarDataCollection overrunHandlerLidarDataCollection;
	private MissLidarDataCollection missHandlerLidarDataCollection;

	private static int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
	private static SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

	/**
	 * This is the constructor for the lidarDataCollection RealtimeThread
	 * 
	 * @param logger
	 * @param management
	 * @param lidarController
	 * @param missHandlerLidarDataCollection
	 * @param qLidarSensor
	 */
	public TLidarDataCollection(Logger logger, IManagementControl management, ILidarInterface lidarController,
			MissLidarDataCollection missHandlerLidarDataCollection, ArrayBlockingQueue<ILidarSensor> qLidarSensor) {
		setName("LidarDataCollectionThread");
		this.logger = logger;
		this.management = management;
		this.lidarController = lidarController;
		this.missHandlerLidarDataCollection = missHandlerLidarDataCollection;
		this.qLidarSensor = qLidarSensor;

		overrunHandlerLidarDataCollection = new OverrunLidarDataCollection(logger);
		overrunHandlerLidarDataCollection.setThread(this);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(2000, 0),
				new RelativeTime(1500, 0), new RelativeTime(2000, 0), this.overrunHandlerLidarDataCollection,
				this.missHandlerLidarDataCollection);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);
	}

	@Override
	public void setOverrunLogger(Logger logger) {
		this.logger = logger;
		overrunHandlerLidarDataCollection.setLogger(logger);

	}

	@Override
	public void run() {
		startLidarRotation();
		try {
			logger.info("Creating LidarDataCollectionThread");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptibleLidarDataCollection inLidarDataCollection = new InterruptibleLidarDataCollection(logger,
					management, lidarController, qLidarSensor);
			asInterruptedException.doInterruptible(inLidarDataCollection);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableLidarDataCollection", e);
		}

	}

	private void startLidarRotation() {
		if (lidarController.isEnabled()) {
			lidarController.init();
			lidarController.startRotation();
		}
	}

}
