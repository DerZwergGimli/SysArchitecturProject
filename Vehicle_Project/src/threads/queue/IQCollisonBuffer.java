package threads.queue;

import collisonAvoidance.ICollisonAvoidance;
import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

public interface IQCollisonBuffer {
	public ILidarSensor getLidarSensor();

	public ICollisonAvoidance getCollisonAvoidance();

	public IStopWatch getStopWatch();

}
