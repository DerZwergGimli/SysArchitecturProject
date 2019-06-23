package gpioInterface.lidar;

import redisInterface.IRedisDBInterface;

/**
 * This is a interface to store the informations of a lidar sensor
 * 
 * @author yannick
 *
 */
public interface ILidarSensor {

	/**
	 * Used if no lidar sensor is present will generate random values
	 */
	public void setRandomDistances();

	/**
	 * This will print all values to the console using system.out.print()
	 */
	public void printValues();

	/**
	 * This will be used to write the values to the databse
	 * 
	 * @param redis
	 */
	public void writeToDB(IRedisDBInterface redis);

	/**
	 * This will be used to set the lidar distances to this object
	 * 
	 * @param distances
	 */
	public void setDistances(int[] distances);

	/**
	 * This is useful if you want to split the 360Lidar-scan into smaller
	 * parts/sections
	 * 
	 * @param startAngle
	 * @param endAngle
	 * @return
	 */
	public int[] getDistancesBySection(int startAngle, int endAngle);
}
