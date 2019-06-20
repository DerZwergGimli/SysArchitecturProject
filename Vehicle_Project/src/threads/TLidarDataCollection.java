package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.SchedulingParameters;

import management.IManagementControl;
import redis.IRedisDBInterface;
import threads.interruptible.InterruptableLidarDataCollection;

public class TLidarDataCollection extends RealtimeThread {
	private Logger logger;
	private IManagementControl management;
	private IRedisDBInterface redis;

	private static int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
	private static SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

	public TLidarDataCollection(Logger logger, IManagementControl management) {
		this.logger = logger;
		this.management = management;
		setName("LidarDataCollectionThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		// ReleaseParameters releaseParameters = new PeriodicParameters(new
		// RelativeTime(), null, null, null, null, null);

		setSchedulingParameters(schedulingParameters);
		// setReleaseParameters(releaseParameters);
	}

	@Override
	public void run() {
		try {
			logger.info("Creating LidarDataCollectionThread");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptableLidarDataCollection inLidarDataCollection = new InterruptableLidarDataCollection(logger,
					management);
			asInterruptedException.doInterruptible(inLidarDataCollection);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableLidarDataCollection", e);
		}

	}
}
