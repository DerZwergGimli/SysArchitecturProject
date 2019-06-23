package threads.handler;

import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.RealtimeThread;

/**
 * Interface for a MissHander
 * 
 * @author yannick
 *
 */
public interface IMissHandler {

	/**
	 * This will set the interrupt-exception needs to be called when
	 * interrupt-exeception is created in Realtimethread-Class
	 * 
	 * @param asInterrupExeption
	 */
	public void setInterruptExeption(AsynchronouslyInterruptedException asInterrupExeption);

	/**
	 * This will set a reference to the RealtimeThread - needed to interact with
	 * start/stop/release
	 * 
	 * @param realtimeThread
	 */
	public void setThread(RealtimeThread realtimeThread);

	/**
	 * This will set a reference to logger to log messages
	 * 
	 * @param logger
	 */
	public void setLogger(Logger logger);

}
