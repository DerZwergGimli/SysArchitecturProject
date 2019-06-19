package collisonAvoidance;

import other.IStopWatch;

public class QCollisonBuffer implements IQCollisonBuffer {

	private ILidarSensor lidarSensor;
	private IStopWatch stopwatch;

	public QCollisonBuffer(ILidarSensor lidarSensor, IStopWatch stopWatch) {
		this.lidarSensor = lidarSensor;
		this.stopwatch = stopWatch;
	}

	@Override
	public ILidarSensor getLidarSensor() {
		return this.lidarSensor;
	}

	@Override
	public IStopWatch getStopWatch() {
		return this.stopwatch;
	}
}
