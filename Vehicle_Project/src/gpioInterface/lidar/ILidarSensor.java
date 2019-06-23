package gpioInterface.lidar;

import redisInterface.IRedisDBInterface;

public interface ILidarSensor {

	public void setRandomDistances();

	public void printValues();

	public void writeToDB(IRedisDBInterface redis);

	public void setDistances(int[] distances);

	public int[] getDistancesBySection(int startAngle, int endAngle);
}
