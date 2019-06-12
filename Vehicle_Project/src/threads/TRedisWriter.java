package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

import objects.LidarSensor;
import os.NetworkInterface;
import os.OSSensorInterface;
import redis.RedisDBInterface;

public class TRedisWriter extends RealtimeThread {

	RedisDBInterface redis;
	Logger logger;
	ArrayBlockingQueue<LidarSensor> lidarSensorQueue;
	Boolean running;
	int redisExpireTime = 1000;

	public TRedisWriter(Logger logger, ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.logger = logger;
		this.lidarSensorQueue = lidarSensorQueue;
		redis = new RedisDBInterface(logger);

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 4;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(500, 0), null,
				null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	public void activate() {
		this.running = true;
	}

	public void disable() {
		this.running = false;
	}

	@Override
	public void run() {
		while (waitForNextPeriod() && running) {
			writeLidarValuesToDatabase();
			writeNetworkDataToDatabase();
			writeOSSensorsToDatabase();
		}
	}

	public void writeLidarValuesToDatabase() {
		LidarSensor sensorLidar = lidarSensorQueue.poll();
		sensorLidar.writeToDB(redis);
	}

	public void writeNetworkDataToDatabase() {
		NetworkInterface networkInterface0 = new NetworkInterface("wlp2s0");
		networkInterface0.readNetworkInterface();
		networkInterface0.writeToDatabase(redis);
	}

	public void writeOSSensorsToDatabase() {
		OSSensorInterface osSensors = new OSSensorInterface();
		osSensors.readOSSensors();
		osSensors.writeToDatabase(redis);
	}

}
