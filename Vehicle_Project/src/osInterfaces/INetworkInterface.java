package osInterfaces;

import redis.IRedisDBInterface;

public interface INetworkInterface {

	public void readNetworkInterface();

	public void writeToDatabase(IRedisDBInterface redis);

	@Override
	public String toString();

}
