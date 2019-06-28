package osInterfaces;

import redisInterface.IRedisDBInterface;

/**
 * This interface is used to access the CPU temperature of the system
 * 
 * @author yannick
 *
 */
public interface ISensorsInterface {

	/**
	 * This will read the current CPU temperature
	 */
	public void readOSSensors();

	/**
	 * This will write the current CPU temperature to the redis database
	 * 
	 * @param redis
	 */
	public void writeToDatabase(IRedisDBInterface redis);

}
