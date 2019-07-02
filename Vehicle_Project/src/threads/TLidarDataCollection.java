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

import gpioInterface.lidar.ILidarInterface;
import management.IManagementControl;
import threads.handler.MissLidarDataCollection;
import threads.handler.OverrunLidarDataCollection;
import threads.interruptible.InterruptibleLidarDataCollection;
import threads.queue.IQLidarBuffer;

/**
 * This RealtimeThread is used to read the values periodically form a
 * lidar-Sensor
 * 
 * @author yannick
 *
 */
public class TLidarDataCollection extends RealtimeThread implements IHandableThread {
	private static int periode;
	private static int cost;
	private static int deadline;

	private Logger logger;
	private IManagementControl management;
	private ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer;
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
	 * @param qLidarBuffer
	 */
	public TLidarDataCollection(Logger logger, IManagementControl management, ILidarInterface lidarController,
			MissLidarDataCollection missHandlerLidarDataCollection, ArrayBlockingQueue<IQLidarBuffer> qLidarBuffer) {
		setName("LidarDataCollectionThread");
		this.logger = logger;
		this.management = management;
		this.lidarController = lidarController;
		this.missHandlerLidarDataCollection = missHandlerLidarDataCollection;
		this.qLidarBuffer = qLidarBuffer;
		readPropertiesFile();

		overrunHandlerLidarDataCollection = new OverrunLidarDataCollection(logger);
		overrunHandlerLidarDataCollection.setThread(this);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(periode, 0),
				new RelativeTime(cost, 0), new RelativeTime(deadline, 0), this.overrunHandlerLidarDataCollection,
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
		try {
			logger.info("Creating LidarDataCollectionThread");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			missHandlerLidarDataCollection.setInterruptExeption(asInterruptedException);
			InterruptibleLidarDataCollection inLidarDataCollection = new InterruptibleLidarDataCollection(logger,
					management, lidarController, qLidarBuffer);
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

	private void stopLidarRotation() {
		if (lidarController.isEnabled()) {
			lidarController.stopRotation();
		}
	}

	private static void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config_vehicle.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			periode = Integer.valueOf(properties.getProperty("lidar.periode"));
			cost = Integer.valueOf(properties.getProperty("lidar.cost"));
			deadline = Integer.valueOf(properties.getProperty("lidar.deadline"));

		} catch (Exception ex) {
			System.out.println("Error while trying to read config for Logger!!! ");

		}
	}

}
