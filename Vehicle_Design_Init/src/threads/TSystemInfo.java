package threads;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

public class TSystemInfo extends RealtimeThread {

	public TSystemInfo() {
		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);
		setSchedulingParameters(schedulingParameter);
		setReleaseParameters(releaseParameter);

	}

	@Override
	public void run() {
		// TODO: somehow we have to ensure that our theard is running only 20 ms

		int n = 1;
		// while (waitForNextPeriod() && (n < 100)) {
		while (waitForNextPeriod()) {
			System.out.println(n);

			n++;
		}

	}

}
