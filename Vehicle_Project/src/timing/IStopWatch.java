package timing;

import redisInterface.IRedisDBInterface;

/**
 * This is the interface for a stopWatch
 * 
 * @author yannick
 *
 */
public interface IStopWatch {

	/**
	 * Will initialize a simple StopWatch
	 */
	public void init();

	/**
	 * Will save the current system time
	 */
	public void start();

	/**
	 * Will save the current system time
	 */
	public void stop();

	/**
	 * Will do the same as stop() but with a calculation
	 */
	public void stopAndCalulate();

	/**
	 * Will calculate the duration between start and stop
	 */
	public void calculateDuration();

	/**
	 * Will write start/stop/duration to the redis-database
	 * 
	 * @param redis
	 */
	public void writeToDB(IRedisDBInterface redis);

}
