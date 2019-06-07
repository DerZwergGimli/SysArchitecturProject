package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

import threads.TLidar;

public class ASHanderRTOverrun extends AsyncEventHandler {

	Logger logger;
	TLidar realtimeThread;

	public ASHanderRTOverrun(Logger logger, TLidar realtimeThread) {
		this.logger = logger;
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void handleAsyncEvent() {
		logger.log(Level.SEVERE, "----------------------OVERRUN DETECTED-----------------------------");
		// realtimeThread.interrupt();
		realtimeThread.kill();
		System.out.println("IS Interrupted_overrun: " + realtimeThread.isInterrupted());
//		while (this.getAndDecrementPendingFireCount() != 0) {
//			System.out.println("FireCount_overrun = " + this.getPendingFireCount());
//		}

		return;

	}

}
