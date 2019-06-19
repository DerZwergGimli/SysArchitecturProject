package other;

import redis.IRedisDBInterface;

public class StopWatch implements IStopWatch {

	private int expireTimeRedis = 100;
	private long startTimeNano;
	private long endTimeNamo;
	private long diffTimeNano;

	public StopWatch() {
	}

	@Override
	public void init() {
		startTimeNano = 0;
		endTimeNamo = 0;
		diffTimeNano = 0;
	}

	@Override
	public void start() {
		startTimeNano = System.nanoTime();
	}

	@Override
	public void stop() {
		endTimeNamo = System.nanoTime();
	}

	@Override
	public void stopAndCalulate() {
		endTimeNamo = System.nanoTime();
		calculateDuration();
	}

	@Override
	public void calculateDuration() {
		diffTimeNano = endTimeNamo - startTimeNano;
	}

	@Override
	public void writeToDB(IRedisDBInterface redis) {
		String parentTopic = "sensors:thread:collionControllExecutionTime:";
		redis.setAndExpire(parentTopic + "startTimeNano", String.valueOf(startTimeNano), expireTimeRedis);
		redis.setAndExpire(parentTopic + "endTimeNano", String.valueOf(endTimeNamo), expireTimeRedis);
		redis.setAndExpire(parentTopic + "diffTimeNano", String.valueOf(diffTimeNano), expireTimeRedis);
	}

}
