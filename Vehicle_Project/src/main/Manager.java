package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import objects.ManagementControl;
import redis.RedisDBInterface;
import threads.TCollisionAvoidance;
import threads.TReaderDB;
import threads.TWriteDB;
import threads.handler.MissCollisonAvoidance;

public class Manager extends RealtimeThread {
	private ManagementControl management;

	volatile private Logger logger;
	MissCollisonAvoidance missCollisonAvoidance;// = new MissCollisonAvoidance();
	ArrayBlockingQueue<LidarSensor> lidarSensorQueue; // = new ArrayBlockingQueue<LidarSensor>(1);
	TCollisionAvoidance threadCollisionAvoidance; // = new TCollisionAvoidance(logger, missCollisonAvoidance,
	// lidarSensorQueue);
	TWriteDB threadWriterDB;
	TReaderDB threadReaderDB;

	public Manager(Logger logger) {
		this.logger = logger;
		setName("ManagerThread");
		management = new ManagementControl();
		management.writeEntriesToDatabase(new RedisDBInterface(logger));

		// LIDAR
		missCollisonAvoidance = new MissCollisonAvoidance(logger);
		lidarSensorQueue = new ArrayBlockingQueue<LidarSensor>(1);
		threadCollisionAvoidance = new TCollisionAvoidance(logger, missCollisonAvoidance, lidarSensorQueue);
		missCollisonAvoidance.setThread(threadCollisionAvoidance);

		// Redis DB Writer
		threadWriterDB = new TWriteDB(logger, management, lidarSensorQueue);

		// Controller (redis-read)
		threadReaderDB = new TReaderDB(logger);

	}

	public void startThreads() {
		threadCollisionAvoidance.start();
		threadWriterDB.start();
	}

	public void joinThreads() {
		try {
			threadCollisionAvoidance.join();
			threadWriterDB.join();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error while joining thread", e);
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
//		// threadCollisionAvoidance.activate();
//		threadCollisionAvoidance.start();
//		threadWriterDB.start();
//		// threadReaderDB.start();
//
//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// management.makeDatabaseWriterThreadUnrunnable();
//
//		try {
//			threadCollisionAvoidance.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		threadWriterDB.interrupt();
//		threadReaderDB.interrupt();
//		threadCollisionAvoidance.interrupt();
//		joinThreads();
//
//		try {
//			sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		manage();

	}

	public void manage() {
		management.readEntriesFormDatabase(new RedisDBInterface(logger));
		management.printAll();
		// threadWriterDB.start();
		while (management.isManagemnetThreadRunnable()) {
			manageCollisonAvoidanceThread();
			manageDatabaseWriterThread();
			management.readEntriesFormDatabase(new RedisDBInterface(logger));

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void manageCollisonAvoidanceThread() {
		if (Thread.State.NEW == threadCollisionAvoidance.getState()) {
			if (management.isCollisonAvoidanceThreadRunnable()) {
				threadCollisionAvoidance.start();
			}
		}
		if (Thread.State.RUNNABLE == threadCollisionAvoidance.getState()) {

		}
		if (Thread.State.TERMINATED == threadCollisionAvoidance.getState()) {
			if (management.isCollisonAvoidanceThreadRunnable()) {
				missCollisonAvoidance = new MissCollisonAvoidance(logger);
				lidarSensorQueue = new ArrayBlockingQueue<LidarSensor>(1);
				threadCollisionAvoidance = new TCollisionAvoidance(logger, missCollisonAvoidance, lidarSensorQueue);
				missCollisonAvoidance.setThread(threadCollisionAvoidance);
			}
		}
		if (Thread.State.TIMED_WAITING == threadCollisionAvoidance.getState()) {
		}
		if (Thread.State.WAITING == threadCollisionAvoidance.getState()) {
		}
		if (Thread.State.BLOCKED == threadCollisionAvoidance.getState()) {
		}

	}

	public void manageDatabaseWriterThread() {
		if (Thread.State.NEW == threadWriterDB.getState()) {
			if (management.isDatabaseWriterThreadRunnable()) {
				threadWriterDB.start();
			}
		}
		if (Thread.State.RUNNABLE == threadWriterDB.getState()) {

		}
		if (Thread.State.TERMINATED == threadWriterDB.getState()) {
			if (management.isDatabaseWriterThreadRunnable()) {
				threadWriterDB = new TWriteDB(logger, management, lidarSensorQueue);
			}
		}
		if (Thread.State.TIMED_WAITING == threadWriterDB.getState()) {
		}
		if (Thread.State.WAITING == threadWriterDB.getState()) {
		}
		if (Thread.State.BLOCKED == threadWriterDB.getState()) {
		}

	}

}
