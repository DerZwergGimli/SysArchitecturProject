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
	private MissCollisonAvoidance missCollisonAvoidance;// = new MissCollisonAvoidance();
	private ArrayBlockingQueue<LidarSensor> lidarSensorQueue; // = new ArrayBlockingQueue<LidarSensor>(1);
	private TCollisionAvoidance threadCollisionAvoidance; // = new TCollisionAvoidance(logger, missCollisonAvoidance,
	// lidarSensorQueue);
	private TWriteDB threadWriterDB;
	private TReaderDB threadReaderDB;

	public Manager(Logger logger) {
		this.logger = logger;
		setName("ManagerThread");
		management = new ManagementControl();
		management.writeEntriesToDatabase(new RedisDBInterface(logger));

		lidarSensorQueue = new ArrayBlockingQueue<LidarSensor>(1);

		// Controller (redis-read)

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

		while (management.isManagemnetThreadRunnable()) {
			management.readEntriesFormDatabase(new RedisDBInterface(logger));
			manageCollisonAvoidanceThread();
			manageDatabaseWriterThread();
			manageDatabaseReaderThread();

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (!management.isManagemnetThreadRunnable()) {
			logger.log(Level.WARNING, "Managemt diabled the programm will now close! And stop all threads clean!");

			management.makeCollisonAvoidanceThreadUnrunnable();
			management.makeDatabaseWriterThreadUnrunnable();
			management.makeDatabaseReaderThreadUnrunnable();

			try {
				threadCollisionAvoidance.join();
				threadReaderDB.join();
				threadWriterDB.join();
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Error while trying to cancel and join the threads!", e);
			}
		}
	}

	public void manageCollisonAvoidanceThread() {
		if (null == threadCollisionAvoidance && management.isCollisonAvoidanceThreadRunnable()) {
			missCollisonAvoidance = new MissCollisonAvoidance(logger);
			threadCollisionAvoidance = new TCollisionAvoidance(logger, management, missCollisonAvoidance,
					lidarSensorQueue);
			missCollisonAvoidance.setThread(threadCollisionAvoidance);
		}
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
				threadCollisionAvoidance = new TCollisionAvoidance(logger, management, missCollisonAvoidance,
						lidarSensorQueue);
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
		if (null == threadWriterDB && management.isDatabaseWriterThreadRunnable()) {
			threadWriterDB = new TWriteDB(logger, management, lidarSensorQueue);
		}
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

	public void manageDatabaseReaderThread() {
		if (null == threadReaderDB && management.isDatabaseReaderThreadRunnable()) {
			threadReaderDB = new TReaderDB(logger, management);
		}
		if (Thread.State.NEW == threadReaderDB.getState()) {
			if (management.isDatabaseReaderThreadRunnable()) {
				threadReaderDB.start();
			}
		}
		if (Thread.State.RUNNABLE == threadReaderDB.getState()) {

		}
		if (Thread.State.TERMINATED == threadReaderDB.getState()) {
			if (management.isDatabaseReaderThreadRunnable()) {
				threadReaderDB = new TReaderDB(logger, management);
			}
		}
		if (Thread.State.TIMED_WAITING == threadReaderDB.getState()) {
		}
		if (Thread.State.WAITING == threadReaderDB.getState()) {
		}
		if (Thread.State.BLOCKED == threadReaderDB.getState()) {
		}

	}

}
