package threads.queue;

import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

public interface IQLidarBuffer {

	/**
	 * This will return the interface of LidarSensor-Object inside a queue
	 * 
	 * @return
	 */
	public ILidarSensor getLidarSensor();

	/**
	 * This will return the interface of StopWatch-Object inside this queue
	 * 
	 * @return
	 */
	public IStopWatch getStopWatch();

}
