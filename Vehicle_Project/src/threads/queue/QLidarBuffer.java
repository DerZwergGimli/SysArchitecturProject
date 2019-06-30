package threads.queue;

import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

public class QLidarBuffer implements IQLidarBuffer {
	private ILidarSensor lidarSensor;
	private IStopWatch stopWatch;

	public QLidarBuffer(ILidarSensor lidarSensor, IStopWatch stopWatch) {
		this.lidarSensor = lidarSensor;
		this.stopWatch = stopWatch;
	}

	@Override
	public ILidarSensor getLidarSensor() {
		return this.lidarSensor;
	}

	@Override
	public IStopWatch getStopWatch() {
		return this.stopWatch;
	}

}
