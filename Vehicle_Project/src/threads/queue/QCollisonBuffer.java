package threads.queue;

import collisonAvoidance.ICollisonAvoidance;
import gpioInterface.lidar.ILidarSensor;
import timing.IStopWatch;

public class QCollisonBuffer implements IQCollisonBuffer {

	private ILidarSensor lidarSensor;
	private IStopWatch stopwatch;
	private ICollisonAvoidance collisonAvoidance;

	public QCollisonBuffer(ILidarSensor lidarSensor, ICollisonAvoidance collisonAvoidance, IStopWatch stopWatch) {
		this.lidarSensor = lidarSensor;
		this.collisonAvoidance = collisonAvoidance;
		this.stopwatch = stopWatch;
	}

	@Override
	public ILidarSensor getLidarSensor() {
		return this.lidarSensor;
	}

	@Override
	public ICollisonAvoidance getCollisonAvoidance() {
		return this.collisonAvoidance;
	}

	@Override
	public IStopWatch getStopWatch() {
		return this.stopwatch;
	}

}
