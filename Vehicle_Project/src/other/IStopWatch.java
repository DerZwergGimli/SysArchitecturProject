package other;

import redis.IRedisDBInterface;

public interface IStopWatch {

	public void init();

	public void start();

	public void stop();

	public void stopAndCalulate();

	public void calculateDuration();

	public void writeToDB(IRedisDBInterface redis);

}
