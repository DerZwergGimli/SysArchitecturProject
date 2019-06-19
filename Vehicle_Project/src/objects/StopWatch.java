package objects;

import redis.RedisDBInterface;

public class StopWatch {

	private int expireTimeRedis = 100;
	private long startTimeNano;
	private long endTimeNamo;
	private long diffTimeNano;

	public StopWatch() {
	}

	public void init() {
		startTimeNano = 0;
		endTimeNamo = 0;
		diffTimeNano = 0;
	}

	public void start() {
		startTimeNano = System.nanoTime();
	}

	public void stop() {
		endTimeNamo = System.nanoTime();
	}

	public void stopAndCalulate() {
		endTimeNamo = System.nanoTime();
		calculateDuration();
	}

	public void calculateDuration() {
		diffTimeNano = endTimeNamo - startTimeNano;
	}

	public void writeToDB(RedisDBInterface redis) {
		String parentTopic = "sensors:thread:collionControllExecutionTime:";
		redis.setAndExpire(parentTopic + "startTimeNano", String.valueOf(startTimeNano), expireTimeRedis);
		redis.setAndExpire(parentTopic + "endTimeNano", String.valueOf(endTimeNamo), expireTimeRedis);
		redis.setAndExpire(parentTopic + "diffTimeNano", String.valueOf(diffTimeNano), expireTimeRedis);
	}

}
