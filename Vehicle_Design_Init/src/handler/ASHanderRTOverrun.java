package handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;

public class ASHanderRTOverrun extends AsyncEventHandler {

	Logger logger;

	public ASHanderRTOverrun(Logger logger, long threadID) {
		this.logger = logger;
	}

	@Override
	public void handleAsyncEvent() {
		System.out.println();
		logger.log(Level.SEVERE, "----------------------OVERRUN DETECTED-----------------------------");
	}

}
