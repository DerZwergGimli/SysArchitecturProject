package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

import threads.TRealTime;

public class ASHanderRTOverrun extends AsyncEventHandler {

	Logger logger;
	TRealTime realtimeThread;

	public ASHanderRTOverrun(Logger logger, TRealTime realtimeThread) {
		this.logger = logger;
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void handleAsyncEvent() {
		logger.log(Level.SEVERE, "----------------------OVERRUN DETECTED-----------------------------");
		realtimeThread.interrupt();
		while (this.getAndDecrementPendingFireCount() != 0) {
			System.out.println("FireCount = " + this.getPendingFireCount());
		}

	}

}
