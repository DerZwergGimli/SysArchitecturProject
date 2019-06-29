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

import management.IManagementControl;
import redisInterface.IRedisDBInterface;
import threads.interruptible.InterruptibleWriterDB;
import threads.queue.IQCollisonBuffer;

/**
 * This RealtimeThread is used to read periodically from a database
 * 
 * @author yannick
 *
 */
public class TWriterDB extends RealtimeThread {

	Logger logger;
	IManagementControl management;

	// ArrayBlockingQueue<LidarSensor> lidarSensorQueue;
	ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;
	Boolean running;
	IRedisDBInterface redis;

	/**
	 * This is the constructor for a Writer-database_thread to write entries
	 * periodically to a Database
	 * 
	 * @param logger
	 * @param management
	 * @param qCollisonControl
	 */
	public TWriterDB(Logger logger, IManagementControl management,
			ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl, IRedisDBInterface redis) {
		this.logger = logger;
		this.management = management;
		this.qCollisonControl = qCollisonControl;
		this.redis = redis;
		setName("DatabaseWriterThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 4;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(2000, 0),
				null, null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	@Override
	public void run() {

		try {
			logger.info("Creating InterruptableWriterDB");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptibleWriterDB inWriterDB = new InterruptibleWriterDB(logger, management, qCollisonControl, redis);
			asInterruptedException.doInterruptible(inWriterDB);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableWriterDB", e);
		}

	}

}
