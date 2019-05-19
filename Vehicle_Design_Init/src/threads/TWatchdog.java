package threads;

import javax.realtime.RealtimeThread;

import objects.WatchdogCounter;

public class TWatchdog extends RealtimeThread {

	RealtimeThread systemInfoRealtimeThread;
	WatchdogCounter watchdogCounter;

	public TWatchdog(RealtimeThread systemInfoRealtimeThread, WatchdogCounter watchdogCounter) {
		this.systemInfoRealtimeThread = systemInfoRealtimeThread;
		this.watchdogCounter = watchdogCounter;

	}

	@Override
	public void run() {
		while (Thread.State.TERMINATED != systemInfoRealtimeThread.getState()) {
			this.watchdogCounter.countDOWN();

			if (watchdogCounter.getCounter() <= 0) {
				System.out.println("Error with realtimeThread");

			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Map<Thread, StackTraceElement[]> threads_StackTrace = getAllStackTraces();
		// TODO Watchdog_Timer

		// StackTraceElement[] systemInfoRT_Stack =
		// systemInfoRealtimeThread.getStackTrace();

//		while (Thread.State.TERMINATED != systemInfoRealtimeThread.getState()) {
//
//			System.out.println(systemInfoRealtimeThread.getState());
//		}

//		while (Thread.State.TERMINATED != sysRealtimeThread.getState()) {
//			if (Thread.State.RUNNABLE == sysRealtimeThread.getState()) {
//				startTimeNano = System.nanoTime();
//			}
//			if (Thread.State.TIMED_WAITING == sysRealtimeThread.getState()) {
//				endTimeNano = System.nanoTime();
//			}
//			System.out.println((endTimeNano - startTimeNano) / 1000000);
//		}

	}
}
