package threads.handler;

import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

/**
 * Interface to a OverrunHandler
 * 
 * @author yannick
 *
 */
public interface IOverrunHandler {

	/**
	 * This will set a reference to a logger to log messages
	 * 
	 * @param logger
	 */
	public void setLogger(Logger logger);

	/**
	 * This will set a reference to a Realtimethread used to increase time on this
	 * thread
	 * 
	 * @param realtimeThread
	 */
	public void setThread(RealtimeThread realtimeThread);
}
