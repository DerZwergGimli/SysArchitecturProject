package osInterfaces;

import redisInterface.IRedisDBInterface;

public interface ITopInterface {

	public void readOSLinuxTopInterface();

	public void writeToDatabase(IRedisDBInterface redis);
}
