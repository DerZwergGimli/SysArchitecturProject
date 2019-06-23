package threads.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;

/**
 * Concrete OverrunHandler for the lidarDataCollection
 * 
 * @author yannick
 *
 */
public class OverrunLidarDataCollection extends AsyncEventHandler implements IOverrunHandler {

	/**
	 * Constructor for a OverrunHandler for lidarDataCollection
	 * 
	 * @param logger
	 */
	public OverrunLidarDataCollection(Logger logger) {
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
		logger.log(Level.WARNING, "Overrun detected in Lidar Data Collecton increasing time!");

		ReleaseParameters releaseParameters = realtimeThread.getReleaseParameters();
		RelativeTime cost = releaseParameters.getCost();
		releaseParameters.setCost(cost.add(1, 0, cost));

		realtimeThread.schedulePeriodic();

	}
}
