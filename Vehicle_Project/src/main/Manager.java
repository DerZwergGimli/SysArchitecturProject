package main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

import gpioInterface.lidar.ILidarSensor;
import gpioInterface.lidar.LidarInterface;
import management.ManagementControl;
import redisInterface.RedisDBInterface;
import threads.TCollisionAvoidance;
import threads.TLidarDataCollection;
import threads.TReaderDB;
import threads.TWriterDB;
import threads.handler.MissCollisonAvoidance;
import threads.handler.MissLidarDataCollection;
import threads.queue.IQCollisonBuffer;

/**
 * This RealtimeThread is used to control the application using
 * ManagementControl
 * 
 * @author yannick
 *
 */
public class Manager extends RealtimeThread {

	private Logger logger;
	private RedisDBInterface redis;
	private ManagementControl management;
	private volatile LidarInterface lidarController;

	private volatile MissCollisonAvoidance missCollisonAvoidance;
	private volatile MissLidarDataCollection missLidarDataCollection;
	private volatile ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;
	private volatile ArrayBlockingQueue<ILidarSensor> qLidarSensor;

	private TCollisionAvoidance threadCollisionAvoidance;
	private TLidarDataCollection threadLidarDataCollection;
	private TWriterDB threadWriterDB;
	private TReaderDB threadReaderDB;

	/**
	 * This is the constructor for a manager
	 * 
	 * @param logger
	 */
	public Manager(Logger logger) {
		this.logger = logger;
		setName("ManagerThread");

		redis = new RedisDBInterface(logger);

		management = new ManagementControl(logger);
		management.readPropertiesFile();
		management.writeEntriesToDatabase(redis);
		lidarController = new LidarInterface();

		qCollisonControl = new ArrayBlockingQueue<IQCollisonBuffer>(1);
		qLidarSensor = new ArrayBlockingQueue<ILidarSensor>(1);
	}

	@Override
	public void run() {
		manage();
	}

	/**
	 * This needs to be called to manage the application
	 */
	public void manage() {
		management.printAll();

		while (management.isManagemnetThreadRunnable()) {
			clearScreen();
			management.printAll();

			management.readEntriesFormDatabase(redis);

			manageCollisonAvoidanceThread();
			manageLidarDataCollectionThread();
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
			management.makeLidarDataCollectionThreadUnrunnable();
			management.makeDatabaseWriterThreadUnrunnable();
			management.makeDatabaseReaderThreadUnrunnable();
			stopLidarRotaion();

			try {
				threadCollisionAvoidance.join();
				threadReaderDB.join();
				threadWriterDB.join();
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "InterruptedException while trying to cancel and join the threads!", e);
			} catch (NullPointerException e) {
				logger.log(Level.WARNING,
						"Misstaken that some thread not run anymore. But you dont really have to care! \nBecause the application will now shut down anyway!");
			} catch (Exception e) {
				logger.log(Level.SEVERE, "Error while trying to cancel and join the threads!", e);
			}
			redis.close();
		}
	}

	private void manageCollisonAvoidanceThread() {
		if (null == threadCollisionAvoidance && management.isCollisonAvoidanceThreadRunnable()) {
			missCollisonAvoidance = new MissCollisonAvoidance(logger);
			threadCollisionAvoidance = new TCollisionAvoidance(logger, management, missCollisonAvoidance, qLidarSensor,
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
							qLidarSensor, qCollisonControl);
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

	private void manageLidarDataCollectionThread() {

		if (null == threadLidarDataCollection && management.isLidarDataCollectionThreadRunnable()) {

			missLidarDataCollection = new MissLidarDataCollection(logger);
			threadLidarDataCollection = new TLidarDataCollection(logger, management, lidarController,
					missLidarDataCollection, qLidarSensor);
			missLidarDataCollection.setThread(threadLidarDataCollection);
			missLidarDataCollection.setLidarController(lidarController);
		}

		if (threadLidarDataCollection != null) {

			if (Thread.State.NEW == threadLidarDataCollection.getState()) {
				if (management.isLidarDataCollectionThreadRunnable()) {
					threadLidarDataCollection.start();
				}
			}
			if (Thread.State.RUNNABLE == threadLidarDataCollection.getState()) {

			}
			if (Thread.State.TERMINATED == threadLidarDataCollection.getState()) {
				if (management.isLidarDataCollectionThreadRunnable()) {
					missLidarDataCollection = new MissLidarDataCollection(logger);
					threadLidarDataCollection = new TLidarDataCollection(logger, management, lidarController,
							missLidarDataCollection, qLidarSensor);
					missLidarDataCollection.setThread(threadLidarDataCollection);
					missLidarDataCollection.setLidarController(lidarController);
				}
			}
			if (Thread.State.TIMED_WAITING == threadLidarDataCollection.getState()) {
			}
			if (Thread.State.WAITING == threadLidarDataCollection.getState()) {
			}
			if (Thread.State.BLOCKED == threadLidarDataCollection.getState()) {
			}
		}

	}

	private void manageDatabaseWriterThread() {
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

	private void manageDatabaseReaderThread() {
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

	/**
	 * This method can be used to clear the console screen
	 */
	public void clearScreen() {
		if (management.isClearConsoleActive()) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
		}

	}

	private void stopLidarRotaion() {
		LidarInterface lidarInterface = new LidarInterface();
		if (lidarInterface.isEnabled()) {
			lidarInterface.stopRotation();
		}
	}

}
