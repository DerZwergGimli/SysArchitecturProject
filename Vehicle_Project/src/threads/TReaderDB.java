package threads;

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
import threads.interruptible.InterruptibleReaderDB;

/**
 * This RealtimeThread is used to write some entries periodically into a
 * database
 * 
 * @author yannick
 *
 */
public class TReaderDB extends RealtimeThread {

	private Logger logger;
	private IManagementControl management;
	private IRedisDBInterface redis;

	private static int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
	private static SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);
	private static ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(),
			new RelativeTime(300, 0), null, null, null, null);

	/**
	 * This is the constructor for the reader-database thread
	 * 
	 * @param logger
	 * @param management
	 */
	public TReaderDB(Logger logger, IManagementControl management) {
		this.logger = logger;
		this.management = management;
		setName("DatabseReaderThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(1000, 0),
				null, null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);
	}

//	public TReaderDB(Logger logger, ManagementControl management) {
//		super(schedulingParameters, releaseParameters, null, ImmortalMemory.instance(), null, null);
//		this.logger = logger;
//		this.management = management;
//		setName("DatabseReaderThread");
//
//	}

	@Override
	public void run() {
		try {
			logger.info("Creating InterruptableReaderDB");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptibleReaderDB inReaderDB = new InterruptibleReaderDB(logger, management);
			asInterruptedException.doInterruptible(inReaderDB);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableReaderDB", e);
		}

	}

}
