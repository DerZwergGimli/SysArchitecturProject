package osInterfaces;

import redisInterface.IRedisDBInterface;

/**
 * This interface is used to gain access to the network.interface
 * 
 * @author yannick
 *
 */
public interface INetworkInterface {

	/**
	 * This will read the network interface
	 */
	public void readNetworkInterface();

	/**
	 * This will write the entries form a network interface to the redis database
	 * 
	 * @param redis
	 */
	public void writeToDatabase(IRedisDBInterface redis);

	@Override
	public String toString();

}
