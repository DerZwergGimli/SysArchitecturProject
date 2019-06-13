package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import os.NetworkInterface;
import os.OSSensorInterface;
import redis.RedisDBInterface;

public class InterruptableWriterDB implements Interruptible {
	private Logger logger;
	private RedisDBInterface redis;
	private ArrayBlockingQueue<LidarSensor> lidarSensorQueue;

	public InterruptableWriterDB(Logger logger, ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.logger = logger;
		this.lidarSensorQueue = lidarSensorQueue;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB writer thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		RealtimeThread realtimeThread = RealtimeThread.currentRealtimeThread();

		while (true) {
			do {
				redis = new RedisDBInterface(logger);

				writeLidarValuesToDatabase();
				writeNetworkDataToDatabase();
				writeOSSensorsToDatabase();

				redis.close();
			} while (RealtimeThread.waitForNextPeriod());

		}

	}

	private void writeLidarValuesToDatabase() {
		LidarSensor sensorLidar = lidarSensorQueue.poll();
		sensorLidar.writeToDB(redis);
	}

	private void writeNetworkDataToDatabase() {
		NetworkInterface networkInterface0 = new NetworkInterface("wlp2s0");
		networkInterface0.readNetworkInterface();
		networkInterface0.writeToDatabase(redis);
	}

	private void writeOSSensorsToDatabase() {
		OSSensorInterface osSensors = new OSSensorInterface();
		osSensors.readOSSensors();
		osSensors.writeToDatabase(redis);
	}

}
