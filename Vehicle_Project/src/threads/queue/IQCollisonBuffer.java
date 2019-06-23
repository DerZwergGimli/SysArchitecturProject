package threads.queue;

import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

public interface IQCollisonBuffer {
	public ILidarSensor getLidarSensor();

	public IStopWatch getStopWatch();

}
