package osInterfaces;

import redisInterface.IRedisDBInterface;

/**
 * This interface is used to get some system informations using TOP(Linux)
 * 
 * @author yannick
 *
 */
public interface ITopInterface {

	/**
	 * This will read form the TOP command
	 */
	public void readOSLinuxTopInterface();

	/**
	 * This will write the values into a redis database
	 * 
	 * @param redis
	 */
	public void writeToDatabase(IRedisDBInterface redis);
}
