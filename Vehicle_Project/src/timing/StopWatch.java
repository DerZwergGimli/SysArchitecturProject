package timing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import redisInterface.IRedisDBInterface;

public class StopWatch implements IStopWatch {

	private int expireTimeRedis = 100;

	private String timestamp;
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
		generateTimestamp();
	}

	@Override
	public void writeToDB(IRedisDBInterface redis) {
		String parentTopic = "sensors:thread:collionControllExecutionTime:";
		if ((startTimeNano != 0) && (endTimeNamo != 0)) {

			redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
			redis.setAndExpire(parentTopic + "startTimeNano", String.valueOf(startTimeNano), expireTimeRedis);
			redis.setAndExpire(parentTopic + "endTimeNano", String.valueOf(endTimeNamo), expireTimeRedis);
			redis.setAndExpire(parentTopic + "diffTimeNano", String.valueOf(diffTimeNano), expireTimeRedis);
		}
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		timestamp = dateFormat.format(new Date());
	}

}
