package management;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import redisInterface.IRedisDBInterface;

/**
 * This contrete class is used to control/manage the whole application
 * 
 * @author yannick
 *
 */
public class ManagementControl implements IManagementControl {
	private Logger logger;
	private int expireTimeRedis;

	private static String parentTopic = "management:threads:";
	private Boolean clearConsole;
	private Boolean managementThreadRunnable;
	private Boolean collisionAvoidanceThreadRunnable;
	private Boolean lidarDataCollectionThreadRunnable;
	private Boolean databaseWriterThreadRunnable;
	private Boolean databaseReaderThreadRunnable;
	private Boolean exposeControlToDatabase;
	private Boolean showSatusInConsole;

	/**
	 * This is the constructor of the manager
	 * 
	 * @param logger
	 */
	public ManagementControl(Logger logger) {
		this.logger = logger;
	}

	@Override
	public Boolean isClearConsoleActive() {
		return clearConsole;
	}

	// Management
	@Override
	public Boolean isManagemnetThreadRunnable() {
		return managementThreadRunnable;
	}

	@Override
	public void makeManagementThreadRunnable() {
		managementThreadRunnable = true;
	}

	@Override
	public void makeManegementThreadUnrunnable() {
		managementThreadRunnable = false;
	}

	// CollisionAvoidance
	@Override
	public Boolean isCollisonAvoidanceThreadRunnable() {
		return collisionAvoidanceThreadRunnable;
	}

	@Override
	public void makeCollisonAvoidanceThreadRunnable() {
		collisionAvoidanceThreadRunnable = true;
	}

	@Override
	public void makeCollisonAvoidanceThreadUnrunnable() {
		collisionAvoidanceThreadRunnable = false;
	}

	// Lidar-Data-Collection
	@Override
	public Boolean isLidarDataCollectionThreadRunnable() {
		return lidarDataCollectionThreadRunnable;
	}

	@Override
	public void makeLidarDataCollectionThreadRunnable() {
		lidarDataCollectionThreadRunnable = true;

	}

	@Override
	public void makeLidarDataCollectionThreadUnrunnable() {
		lidarDataCollectionThreadRunnable = false;

	}

	// databaseWriter
	@Override
	public Boolean isDatabaseWriterThreadRunnable() {
		return databaseWriterThreadRunnable;
	}

	@Override
	public void makeDatabaseWriterThreadRunnbale() {
		databaseWriterThreadRunnable = true;
	}

	@Override
	public void makeDatabaseWriterThreadUnrunnable() {
		databaseWriterThreadRunnable = false;
	}

	// databaseReader
	@Override
	public Boolean isDatabaseReaderThreadRunnable() {
		return databaseReaderThreadRunnable;
	}

	@Override
	public void makeDatabaseReaderThreadRunnbale() {
		databaseReaderThreadRunnable = true;
	}

	@Override
	public void makeDatabaseReaderThreadUnrunnable() {
		databaseReaderThreadRunnable = false;
	}

	@Override
	public void writeEntriesToDatabase(IRedisDBInterface redis) {
		if (exposeControlToDatabase == true) {
			redis.setAndExpire(parentTopic + "managementThreadRunnable", managementThreadRunnable.toString(),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + "collisonAvoidanceThreadRunnable",
					collisionAvoidanceThreadRunnable.toString(), expireTimeRedis);
			redis.setAndExpire(parentTopic + "lidarDataCollectionThreadRunnable",
					lidarDataCollectionThreadRunnable.toString(), expireTimeRedis);
			redis.setAndExpire(parentTopic + "databaseReaderThreadRunnable", databaseReaderThreadRunnable.toString(),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + "databaseWriterThreadRunnable", databaseWriterThreadRunnable.toString(),
					expireTimeRedis);

		}

	}

	@Override
	public void readEntriesFormDatabase(IRedisDBInterface redis) {
		if ((exposeControlToDatabase == true) && (redis.isEnabled() == true)) {
			managementThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "managementThreadRunnable"));
			collisionAvoidanceThreadRunnable = Boolean
					.parseBoolean(redis.get(parentTopic + "collisonAvoidanceThreadRunnable"));
			lidarDataCollectionThreadRunnable = Boolean
					.parseBoolean(redis.get(parentTopic + "lidarDataCollectionThreadRunnable"));
			databaseReaderThreadRunnable = Boolean
					.parseBoolean(redis.get(parentTopic + "databaseReaderThreadRunnable"));
			databaseWriterThreadRunnable = Boolean
					.parseBoolean(redis.get(parentTopic + "databaseWriterThreadRunnable"));

		}

	}

	@Override
	public void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			this.managementThreadRunnable = Boolean
					.parseBoolean(properties.getProperty("managementControl.managementThreadRunnable", "true"));
			this.lidarDataCollectionThreadRunnable = Boolean
					.parseBoolean(properties.getProperty("managementControl.lidarDataCollection", "true"));
			this.collisionAvoidanceThreadRunnable = Boolean
					.parseBoolean(properties.getProperty("managementControl.collisionAvoidanceThreadRunnable", "true"));
			this.databaseReaderThreadRunnable = Boolean
					.parseBoolean(properties.getProperty("managementControl.databaseReaderThreadRunnable", "true"));
			this.databaseWriterThreadRunnable = Boolean
					.parseBoolean(properties.getProperty("managementControl.databaseWriterThreadRunnable", "true"));
			this.exposeControlToDatabase = Boolean
					.parseBoolean(properties.getProperty("management.exposeControlToDatabase", "true"));
			;
			this.clearConsole = Boolean.parseBoolean(properties.getProperty("console.clearScreen", "false"));
			this.showSatusInConsole = Boolean
					.parseBoolean(properties.getProperty("console.showStatusInConsole", "false"));
			expireTimeRedis = Integer.valueOf(properties.getProperty("redis.expireTime"));

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "Error while trying to read config of RedisDB", ex);

		}
	}

	@Override
	public void printAll() {
		if (this.showSatusInConsole == true) {

			System.out.println("==============================================================================");
			System.out.println("managementThreadRunnable:\t\t" + managementThreadRunnable);
			System.out.println("collisionAvoidanceThreadRunnable:\t" + collisionAvoidanceThreadRunnable);
			System.out.println("lidarDataCollectionThreadRunnable:\t" + lidarDataCollectionThreadRunnable);
			System.out.println("databaseReaderThreadRunnable:\t\t" + databaseReaderThreadRunnable);
			System.out.println("databaseWriterThreadRunnable:\t\t" + databaseWriterThreadRunnable);

		}
	}

}
