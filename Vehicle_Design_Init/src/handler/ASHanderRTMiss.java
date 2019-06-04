package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

import threads.TLidar;

public class ASHanderRTMiss extends AsyncEventHandler {

	Logger logger;
	TLidar realtimeThread;

	public ASHanderRTMiss(Logger logger, TLidar realtimeThread) {
		this.logger = logger;
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void handleAsyncEvent() {

		logger.log(Level.SEVERE, "----------------------____MISS DETETECTED-----------------------------");
		realtimeThread.kill();
		// realtimeThread.interrupt();
		System.out.println("IS Interrupted_miss: " + realtimeThread.isInterrupted());
//		while (this.getAndDecrementPendingFireCount() != 0) {
//			System.out.println("FireCount_miss = " + this.getPendingFireCount());
//		}

		// realtimeThread.start();
//		while (this.realtimeThread.isInterrupted() != true) {
//			try {
//				realtimeThread.interrupt();
//			} catch (Exception e) {
//				System.out.println("Error while interruping thread");
//			}
//			System.out.println("...trying interrupting");
//		}

		return;

	}

}
