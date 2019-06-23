package threads.queue;

import collisonAvoidance.ICollisonAvoidance;
import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

/**
 * This is the interface for a queue used for passing objects between the
 * lidarScanner and the collisionAvoidance
 * 
 * @author yannick
 *
 */
public interface IQCollisonBuffer {

	/**
	 * This will return the interface of LidarSensor-Object inside a queue
	 * 
	 * @return
	 */
	public ILidarSensor getLidarSensor();

	/**
	 * This will return the interface of CollisonAvidance-Object inside this queue
	 * 
	 * @return
	 */
	public ICollisonAvoidance getCollisonAvoidance();

	/**
	 * This will return the interface of StopWatch-Object inside this queue
	 * 
	 * @return
	 */
	public IStopWatch getStopWatch();

}
