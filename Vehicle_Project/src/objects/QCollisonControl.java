package objects;

public class QCollisonControl {

	private LidarSensor lidarSensor;
	private StopWatch stopwatch;

	public QCollisonControl(LidarSensor lidarSensor, StopWatch stopWatch) {
		this.lidarSensor = lidarSensor;
		this.stopwatch = stopWatch;
	}

	public LidarSensor getLidarSensor() {
		return this.lidarSensor;
	}

	public StopWatch getStopWatch() {
		return this.stopwatch;
	}
}
