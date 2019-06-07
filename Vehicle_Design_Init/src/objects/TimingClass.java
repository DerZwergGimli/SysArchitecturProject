package objects;

public class TimingClass {

	// All measurements are in ns

	private long startTime = 0;
	private long endTime = 0;
	private long durationTime = 0;

	public TimingClass() {
	}

	public synchronized void start() {
		this.startTime = System.nanoTime();
	}

	public synchronized void stop() {
		this.endTime = System.nanoTime();
	}

	public synchronized long getDurationNanoSecounds() {
		calculateDifference();
		return durationTime;
	}

	public synchronized long getDurationMicroSecounds() {
		calculateDifference();
		return durationTime / 1000;
	}

	public synchronized long getDurationMilliSecounds() {
		calculateDifference();
		if (durationTime != 0) {
			return durationTime / 1000000;
		} else {
			return 0;
		}
	}

	private synchronized void calculateDifference() {
		if (endTime > startTime) {
			durationTime = (endTime - startTime);

		} else {
			durationTime = 0;
		}
	}
}
