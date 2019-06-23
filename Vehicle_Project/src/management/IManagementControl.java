package management;

import redisInterface.IRedisDBInterface;

/**
 * This interface is used to manage the whole application
 * 
 * @author yannick
 *
 */
public interface IManagementControl {
	// Clear Console
	public Boolean isClearConsoleActive();

	// Management
	public Boolean isManagemnetThreadRunnable();

	public void makeManagementThreadRunnable();

	public void makeManegementThreadUnrunnable();

	// CollisionAvoidance
	public Boolean isCollisonAvoidanceThreadRunnable();

	public void makeCollisonAvoidanceThreadRunnable();

	public void makeCollisonAvoidanceThreadUnrunnable();

	// Lidar Data Collection
	public Boolean isLidarDataCollectionThreadRunnable();

	public void makeLidarDataCollectionThreadRunnable();

	public void makeLidarDataCollectionThreadUnrunnable();

	// databaseWriter
	public Boolean isDatabaseWriterThreadRunnable();

	public void makeDatabaseWriterThreadRunnbale();

	public void makeDatabaseWriterThreadUnrunnable();

	// databaseReader
	public Boolean isDatabaseReaderThreadRunnable();

	public void makeDatabaseReaderThreadRunnbale();

	public void makeDatabaseReaderThreadUnrunnable();

	// Data for this
	public void writeEntriesToDatabase(IRedisDBInterface redis);

	public void readEntriesFormDatabase(IRedisDBInterface redis);

	public void printAll();

	public void readPropertiesFile();

}
