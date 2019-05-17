package threads;

import javax.realtime.RealtimeThread;

public class TWatchdog extends RealtimeThread {

	RealtimeThread systemInfoRealtimeThread;

	public TWatchdog(RealtimeThread systemInfoRealtimeThread) {
		this.systemInfoRealtimeThread = systemInfoRealtimeThread;

	}

	@Override
	public void run() {
		// Map<Thread, StackTraceElement[]> threads_StackTrace = getAllStackTraces();
		// TODO Watchdog_Timer

		StackTraceElement[] systemInfoRT_Stack = systemInfoRealtimeThread.getStackTrace();

		while (Thread.State.TERMINATED != systemInfoRealtimeThread.getState()) {

			System.out.println(systemInfoRealtimeThread.getState());
		}

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
