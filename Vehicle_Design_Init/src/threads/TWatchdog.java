package threads;

import javax.realtime.RealtimeThread;

public class TWatchdog extends RealtimeThread {

	RealtimeThread sysRealtimeThread;

	public TWatchdog(RealtimeThread sysRealtimeThread) {
		this.sysRealtimeThread = sysRealtimeThread;

	}

	@Override
	public void run() {
		long startTimeNano = 0;
		long endTimeNano = 0;

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
