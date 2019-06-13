package threads;

import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

import redis.RedisDBInterface;
import threads.interruptible.InterruptableReaderDB;

public class TReaderDB extends RealtimeThread {

	private Logger logger;
	private RedisDBInterface redis;

	public TReaderDB(Logger logger) {
		this.logger = logger;
		setName("DatabseReaderThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(300, 0), null,
				null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);
	}

	@Override
	public void run() {
		try {
			logger.info("");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptableReaderDB inReaderDB = new InterruptableReaderDB(logger);
			asInterruptedException.doInterruptible(inReaderDB);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
