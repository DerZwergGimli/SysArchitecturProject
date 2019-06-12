package threads;

import java.util.logging.Logger;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

import redis.RedisDBInterface;

public class TRedisReader extends RealtimeThread {

	private Boolean running;
	private Logger logger;
	private RedisDBInterface redis;

	public TRedisReader(Logger logger) {
		this.logger = logger;

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 5;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(300, 0), null,
				null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);
	}

	public void active() {
		this.running = true;
	}

	public void deactivate() {
		this.running = false;
	}

	@Override
	public void run() {
		while (waitForNextPeriod() && running) {

		}
	}

}
