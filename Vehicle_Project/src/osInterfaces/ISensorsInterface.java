package osInterfaces;

import redis.IRedisDBInterface;

public interface ISensorsInterface {

	public void readOSSensors();

	public void writeToDatabase(IRedisDBInterface redis);

}
