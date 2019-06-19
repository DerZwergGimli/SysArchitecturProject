package collisonAvoidance;

import redis.IRedisDBInterface;

public interface ILidarSensor {

	public void setRandomDistances();

	public void printValues();

	public void writeToDB(IRedisDBInterface redis);

}
