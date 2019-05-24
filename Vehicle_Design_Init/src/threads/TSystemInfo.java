package threads;

import javax.realtime.MemoryParameters;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import objects.RuntimeMeasure;
import objects.WatchdogCounter;

public class TSystemInfo extends RealtimeThread {

	WatchdogCounter watchdogCounter;
	RuntimeMeasure runtime;

	public TSystemInfo(WatchdogCounter watchdogCounter, RuntimeMeasure runtime) {
		this.watchdogCounter = watchdogCounter;
		this.runtime = runtime;
		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);
		MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		setSchedulingParameters(schedulingParameter);
		setReleaseParameters(releaseParameter);
		setMemoryParameters(memoryParamters);

	}

	@Override
	public void run() {
		// TODO: somehow we have to ensure that our theard is running only 20 ms

		int n = 1;
		while (waitForNextPeriod() && (n < 100)) {
			this.runtime.start();
			// while (waitForNextPeriod()) {
			this.watchdogCounter.countReset();
			System.out.println(n);

			n++;
			this.runtime.end();
			System.out.println("Exetime =" + this.runtime.timeConsumtion());

		}

	}

}
