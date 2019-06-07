package objects;

import java.util.concurrent.atomic.AtomicLong;

import communicationinterfaces.JedisDBInterface;

public class OTimeMeasure2 {

	// All measurements are in ns

	AtomicLong startTime;
	AtomicLong endTime;
	AtomicLong durationTime;

	public OTimeMeasure2() {
	}

	public void start() {
		this.startTime.set(System.nanoTime());
	}

	public void stop() {
		this.endTime.set(System.nanoTime());
	}

	public long getDurationNanoSecounds() {
		calculateDifference();
		return durationTime.get();
	}

	public long getDurationMicroSecounds() {
		calculateDifference();
		return durationTime.get() / 1000;
	}

	public long getDurationMilliSecounds() {
		calculateDifference();
		return this.durationTime.get() / 1000000;
	}

	public void writeToDB(String variableName) {
		calculateDifference();

		JedisDBInterface jedisDB = new JedisDBInterface();
		jedisDB.set(variableName, String.valueOf(durationTime.get()));

	}

	private void calculateDifference() {
		if (this.endTime.get() > this.startTime.get()) {
			this.durationTime.set(this.endTime.get() - this.startTime.get());
		}
	}
}
