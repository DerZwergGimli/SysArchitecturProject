package osInterfaces;

import redis.IRedisDBInterface;

public interface ITopInterface {

	public void readOSLinuxTopInterface();

	public void writeToDatabase(IRedisDBInterface redis);
}
