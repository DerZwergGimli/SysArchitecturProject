package threads;

import java.util.logging.Logger;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import handler.ASHanderRTMiss;
import handler.ASHanderRTOverrun;
import objects.TimingClass;

public class TLidar extends RealtimeThread {

	Logger logger;
	TimingClass timing;

	public TLidar(Logger logger, TimingClass timing) {
		this.setName("TSystemInfo");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		RelativeTime costCPU = new RelativeTime(18, 0);
		RelativeTime deadline = new RelativeTime(19, 0);
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);

		PeriodicParameters releaseParamterNEW = new PeriodicParameters(null, period, costCPU, deadline,
				new ASHanderRTOverrun(logger, this), new ASHanderRTMiss(logger, this));

		// MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		this.setSchedulingParameters(schedulingParameter);
		this.setReleaseParameters(releaseParamterNEW);
		// setMemoryParameters(memoryParamters);

		this.logger = logger;
		this.timing = timing;

	}

	@Override
	public void run() {

		int n = 1;

		while ((n < 1000) && !this.isInterrupted()) {
			waitForNextPeriod();

			timing.start();

			System.out.print(n + " - ");
			n++;

			timing.stop();
			System.out.println("TimeConsumption: " + timing.getDurationMicroSecounds() + "us");

		}

	}

}
