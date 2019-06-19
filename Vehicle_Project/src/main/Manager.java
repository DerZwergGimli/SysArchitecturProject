package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

import collisonAvoidance.IQCollisonBuffer;
import management.ManagementControl;
import redis.RedisDBInterface;
import threads.TCollisionAvoidance;
import threads.TReaderDB;
import threads.TWriterDB;
import threads.handler.IMissCollisonAvoidance;
import threads.handler.MissCollisonAvoidance;

public class Manager extends RealtimeThread {
	private Logger logger;
	private RedisDBInterface redis;
	private ManagementControl management;
	private IMissCollisonAvoidance missCollisonAvoidance;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;
	private TCollisionAvoidance threadCollisionAvoidance;
	private TWriterDB threadWriterDB;
	private TReaderDB threadReaderDB;

	public Manager(Logger logger) {
		this.logger = logger;
		setName("ManagerThread");

		redis = new RedisDBInterface(logger);

		management = new ManagementControl(logger);
		management.readPropertiesFile();
		management.writeEntriesToDatabase(redis);

		qCollisonControl = new ArrayBlockingQueue<IQCollisonBuffer>(1);
	}

	@Override
	public void run() {
		manage();
	}

	public void manage() {
		management.printAll();

		while (management.isManagemnetThreadRunnable()) {
			management.readEntriesFormDatabase(redis);

			manageCollisonAvoidanceThread();
			manageDatabaseWriterThread();
			manageDatabaseReaderThread();

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			management.printAll();
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
				logger.log(Level.SEVERE, "InterruptedException while trying to cancel and join the threads!", e);
			} catch (NullPointerException e) {
				logger.log(Level.WARNING,
						"Misstaken that some thread not run anymore. But you dont realy have to care! \nBecause the application will now shut down anyway!");
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error while trying to cancel and join the threads!", e);
			}
		}
	}

	public void manageCollisonAvoidanceThread() {
		if (null == threadCollisionAvoidance && management.isCollisonAvoidanceThreadRunnable()) {
			missCollisonAvoidance = new MissCollisonAvoidance(logger);
			threadCollisionAvoidance = new TCollisionAvoidance(logger, management, missCollisonAvoidance,
					qCollisonControl);
			missCollisonAvoidance.setThread(threadCollisionAvoidance);
		}

		if (threadCollisionAvoidance != null) {

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
							qCollisonControl);
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

	}

	public void manageDatabaseWriterThread() {
		if (null == threadWriterDB && management.isDatabaseWriterThreadRunnable()) {
			threadWriterDB = new TWriterDB(logger, management, qCollisonControl);
		}

		if (threadWriterDB != null) {

			if (Thread.State.NEW == threadWriterDB.getState()) {
				if (management.isDatabaseWriterThreadRunnable()) {
					threadWriterDB.start();
				}
			}
			if (Thread.State.RUNNABLE == threadWriterDB.getState()) {

			}
			if (Thread.State.TERMINATED == threadWriterDB.getState()) {
				if (management.isDatabaseWriterThreadRunnable()) {
					threadWriterDB = new TWriterDB(logger, management, qCollisonControl);
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

	public void manageDatabaseReaderThread() {
		if (null == threadReaderDB && management.isDatabaseReaderThreadRunnable()) {
			threadReaderDB = new TReaderDB(logger, management);
		}
		if (threadReaderDB != null) {

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

}
