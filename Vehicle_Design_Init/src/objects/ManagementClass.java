package objects;

import java.util.logging.Logger;

import operatingSystemInterfaces.NetworkInterface;
import threads.TDatabaseCommunication;
import threads.TLidar;
import threads.TSystemInfo;

public class ManagementClass {

	private Logger logger;

	private boolean managementActive = true;

	public boolean liadarThreadActive = true;
	public boolean systemThreadActive = true;

	TimingClass timerLidarThread = new TimingClass();
	private NetworkInterface networkInterface = new NetworkInterface("wlp2s0");

	private TDatabaseCommunication thread_DatabaseCommunication;
	private TLidar thread_Lidar;
	private TSystemInfo thread_SystemInfo;

	public ManagementClass(Logger logger) {
		this.logger = logger;
		// createAllThreads();

	}

	public void startAllThreads() {
		thread_DatabaseCommunication.start();
		thread_Lidar.start();
		thread_SystemInfo.start();
		logger.info("All Threads started");
	}

	public void killAllThreads() {
		thread_DatabaseCommunication.kill();
		// thread_DatabaseCommunication.interrupt();
		thread_Lidar.kill();
		// thread_Lidar.interrupt();
		thread_SystemInfo.kill();
		// thread_SystemInfo.interrupt();
		logger.info("killed all Threads");

	}

	public void destroyAllThreads() {
		thread_DatabaseCommunication = null;
		thread_Lidar = null;
		thread_SystemInfo = null;
		logger.info("all Threads destroyed");
	}

	public void createAllThreads() {
		this.thread_DatabaseCommunication = new TDatabaseCommunication(timerLidarThread);
		this.thread_Lidar = new TLidar(logger, timerLidarThread);
		this.thread_SystemInfo = new TSystemInfo(networkInterface);
		logger.info("all threads created");
	}

	public void joinAll() {
		try {
			thread_DatabaseCommunication.join();
			thread_Lidar.join();
			thread_SystemInfo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("joined all Threads");

	}

	public void checkStateChange() {
		// TODO do something here
	}

//	public void initializeFromDatabase() {
//		// TODO: remove this
//		JedisDBInterface jedisDB = new JedisDBInterface();
//
//		if (jedisDB.get("management:thread:lidar").contentEquals("true")) {
//			this.liadarThreadActive = true;
//		}
//
//		if (jedisDB.get("management:thread:system").contentEquals("true")) {
//			this.systemThreadActive = true;
//		}
//	}

	public boolean isActive() {
		logger.info("Manager is active? " + managementActive);
		return managementActive;

	}

	public void kill() {
		managementActive = false;
		logger.info("ManagerThread running is set to 'FALSE'");
	}

}
