package objects;

import java.util.logging.Logger;

import communicationinterfaces.JedisDBInterface;
import operatingSystemInterfaces.NetworkInterface;
import threads.TDatabaseCommunication;
import threads.TLidar;
import threads.TSystemInfo;

public class ManagementClass {

	Logger logger;

	private boolean mainProcessActive = true;

	public boolean liadarThreadActive = true;
	public boolean systemThreadActive = true;

	private TimingClass timerLidarThread = new TimingClass();
	NetworkInterface networkInterface = new NetworkInterface("wlp2s0");

	private TDatabaseCommunication databaseCommunicationThread;
	private TLidar lidarThread;
	private TSystemInfo systemInfoThread;

	public ManagementClass(Logger logger) {
		this.logger = logger;
		this.databaseCommunicationThread = new TDatabaseCommunication(timerLidarThread);
		this.lidarThread = new TLidar(logger, timerLidarThread);
		this.systemInfoThread = new TSystemInfo(networkInterface);

		// TODO Auto-generated constructor stub
	}

	public void startAllThreads() {
		databaseCommunicationThread.start();
		lidarThread.start();
		systemInfoThread.start();
	}

	public void killAllThreads() {
		databaseCommunicationThread.interrupt();
		lidarThread.interrupt();
		systemInfoThread.interrupt();
	}

	public void initializeFromDatabase() {
		JedisDBInterface jedisDB = new JedisDBInterface();

		if (jedisDB.get("management:thread:lidar").contentEquals("true")) {
			this.liadarThreadActive = true;
		}

		if (jedisDB.get("management:thread:system").contentEquals("true")) {
			this.systemThreadActive = true;
		}
	}

	public boolean isRunning() {
		return mainProcessActive;
	}

	public void kill() {
		mainProcessActive = false;
	}

}
