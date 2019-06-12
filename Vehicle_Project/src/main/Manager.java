package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import threads.TCollisionAvoidance;
import threads.TRedisReader;
import threads.TRedisWriter;
import threads.handler.MissCollisonAvoidance;

public class Manager extends RealtimeThread {
	Logger logger;
	MissCollisonAvoidance missCollisonAvoidance = new MissCollisonAvoidance();
	ArrayBlockingQueue<LidarSensor> lidarSensorQueue = new ArrayBlockingQueue<LidarSensor>(1);
	TCollisionAvoidance threadCollisionAvoidance = new TCollisionAvoidance(missCollisonAvoidance, lidarSensorQueue);
	TRedisWriter threadRedisWriter;
	TRedisReader threadController;

	public Manager(Logger logger) {
		this.logger = logger;

		// LIDAR
		missCollisonAvoidance.setThread(threadCollisionAvoidance);
		missCollisonAvoidance.setLogger(logger);
		threadCollisionAvoidance.setLogger(logger);

		// Redis DB Writer
		threadRedisWriter = new TRedisWriter(logger, lidarSensorQueue);

		// Controller (redis-read)
		threadController = new TRedisReader(logger);

	}

	public void startThreads() {
		threadCollisionAvoidance.start();
		threadRedisWriter.activate();
		threadRedisWriter.start();
	}

	public void joinThreads() {
		try {
			threadCollisionAvoidance.join();
			threadRedisWriter.disable();
			threadRedisWriter.join();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error while joining thread", e);
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		startThreads();
		joinThreads();
	}

}
