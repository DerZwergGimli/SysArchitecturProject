package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

public class ASHanderRTMiss extends AsyncEventHandler {

	Logger logger;
	long threadID;

	public ASHanderRTMiss(Logger logger, long threadID) {
		this.logger = logger;
		this.threadID = threadID;
	}

	@Override
	public void handleAsyncEvent() {

		System.out.println("----------------___MISS DETETECTED-------------");
		logger.log(Level.SEVERE, "----------------------____MISS DETETECTED-----------------------------");

	}

}
