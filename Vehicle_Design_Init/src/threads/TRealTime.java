package threads;

import java.util.logging.Logger;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import handler.ASHanderRTMiss;
import handler.ASHanderRTOverrun;

public class TRealTime extends RealtimeThread {

	Logger logger;

	public TRealTime(Logger logger) {
		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 1;
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(20 /* ms */, 0 /* ns */); /* period: 20ms */
		RelativeTime costCPU = new RelativeTime(10, 0);
		RelativeTime deadline = new RelativeTime(15, 0);
		PeriodicParameters releaseParameter = new PeriodicParameters(null, period, null, null, null, null);

		PeriodicParameters releaseParamterNEW = new PeriodicParameters(null, period, costCPU, deadline,
				new ASHanderRTOverrun(logger, this), new ASHanderRTMiss(logger, this));

		// MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		setSchedulingParameters(schedulingParameter);
		setReleaseParameters(releaseParamterNEW);
		// setMemoryParameters(memoryParamters);

		this.logger = logger;

	}

	@Override
	public void run() {

		int n = 1;
//		try {
//			while (waitForNextRelease() && (n < 100)) {
//				// while (waitForNextPeriod()) {
//				System.out.println(n);
//
//				Thread.sleep(20);
//
//				n++;
//
//			}
//		} catch (IllegalThreadStateException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			logger.log(Level.SEVERE, "Realtime thread releaseError", e);
//
//		}

		while (waitForNextPeriod() && (n < 100)) {
			while (!this.isInterrupted()) {

				long startTime = System.nanoTime();

				System.out.print(n + " - ");
				for (int i = 0; i < n * 10; i++) {
					for (int j = 0; j < 1000; j++) {

					}
				}

				n++;
				long endTime = System.nanoTime();
				System.out.println((endTime - startTime) / 1000);

			}
		}
	}

}
