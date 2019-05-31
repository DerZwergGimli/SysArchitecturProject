package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

import threads.TRealTime;

public class ASHanderRTMiss extends AsyncEventHandler {

	Logger logger;
	TRealTime realtimeThread;

	public ASHanderRTMiss(Logger logger, TRealTime realtimeThread) {
		this.logger = logger;
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void handleAsyncEvent() {

		// System.out.println("----------------___MISS DETETECTED-------------");
		logger.log(Level.SEVERE, "----------------------____MISS DETETECTED-----------------------------");
		realtimeThread.interrupt();
		while (this.getAndDecrementPendingFireCount() != 0) {
			System.out.println("FireCount = " + this.getPendingFireCount());
		}
		realtimeThread.start();

	}

}
