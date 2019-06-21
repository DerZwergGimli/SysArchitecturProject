package osInterfaces;

import redisInterface.IRedisDBInterface;

public interface ISensorsInterface {

	public void readOSSensors();

	public void writeToDatabase(IRedisDBInterface redis);

}
