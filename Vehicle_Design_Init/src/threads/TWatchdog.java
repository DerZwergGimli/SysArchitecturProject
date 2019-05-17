package threads;

import java.util.Map;

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

		long time = endTimeNano - startTimeNano;

		Map<Thread, StackTraceElement[]> threads_StackTrace = getAllStackTraces();

		try {
			super.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
