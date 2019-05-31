package threads;

import java.util.logging.Logger;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import _trash.WatchdogCounter;
import handler.ASHanderRTMiss;
import handler.ASHanderRTOverrun;

public class TRealTime extends RealtimeThread {

	WatchdogCounter watchdogCounter;

	public TRealTime(Logger logger) {
		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		RelativeTime costCPU = new RelativeTime(10, 0);
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);

		PeriodicParameters releaseParamterNEW = new PeriodicParameters(null, period, costCPU, null,
				new ASHanderRTOverrun(logger, this.getId()), new ASHanderRTMiss(logger, this.getId()));

		// MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		setSchedulingParameters(schedulingParameter);
		setReleaseParameters(releaseParamterNEW);
		// setMemoryParameters(memoryParamters);

	}

	@Override
	public void run() {
		int n = 1;
		while (waitForNextPeriod() && (n < 100)) {
			// while (waitForNextPeriod()) {
			System.out.println(n);

			n++;

		}

	}

}
