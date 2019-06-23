package threads;

import java.util.logging.Logger;

/**
 * The interface that is need when creating a interruptible with a overrun
 * handler else you cannot log into a file
 * 
 * @author yannick
 *
 */
public interface IHandableThread {

	/**
	 * This will set a reference of a logger for the overrunHandler
	 * 
	 * @param logger
	 */
	public void setOverrunLogger(Logger logger);
}
