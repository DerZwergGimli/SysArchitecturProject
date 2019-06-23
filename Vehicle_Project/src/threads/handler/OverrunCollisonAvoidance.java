package threads.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

/**
 * Concrete OverrunHandler for the collionAvoidance
 * 
 * @author yannick
 *
 */
public class OverrunCollisonAvoidance extends AsyncEventHandler implements IOverrunHandler {

	/**
	 * Constructor for a OverrunHandler for collsionAvoidance
	 * 
	 * @param logger
	 */
	public OverrunCollisonAvoidance(Logger logger) {
		this.logger = logger;
	}

	RealtimeThread realtimeThread;
	Logger logger;

	@Override
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void setThread(RealtimeThread realtimeThread) {
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void handleAsyncEvent() {
		logger.log(Level.WARNING, "Overrun detected in CollisionAvoidance increasing time!");

		ReleaseParameters releaseParameters = realtimeThread.getReleaseParameters();
		RelativeTime cost = releaseParameters.getCost();
		releaseParameters.setCost(cost.add(1, 0, cost));

		realtimeThread.schedulePeriodic();

	}

}
