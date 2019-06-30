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

	/**
	 * This is used to check if the console is clear able
	 * 
	 * @return
	 */
	public Boolean isClearConsoleActive();

	// Management
	/**
	 * This will return of the management thread should run
	 * 
	 * @return
	 */
	public Boolean isManagemnetThreadRunnable();

	/**
	 * This will make the management thread runnable
	 */
	public void makeManagementThreadRunnable();

	/**
	 * This will make the management thread un-runnable
	 */
	public void makeManegementThreadUnrunnable();

	// CollisionAvoidance
	/**
	 * This will return of the colliosnAvoidance thread should run
	 * 
	 * @return
	 */
	public Boolean isCollisonAvoidanceThreadRunnable();

	/**
	 * This will make the collionAvoidance thead runnable
	 */
	public void makeCollisonAvoidanceThreadRunnable();

	/**
	 * This will make the collionAvoidance thread un-runnable
	 */
	public void makeCollisonAvoidanceThreadUnrunnable();

	// Lidar Data Collection
	/**
	 * This will return of the lidarDataCollection thread should run
	 * 
	 * @return
	 */
	public Boolean isLidarDataCollectionThreadRunnable();

	/**
	 * This will make the lidarDataCollection thread runnable
	 */
	public void makeLidarDataCollectionThreadRunnable();

	/**
	 * This will make the lidarDataCollection thread un-runnable
	 */
	public void makeLidarDataCollectionThreadUnrunnable();

	// databaseWriter
	/**
	 * This will return of the databaseWriter thread should run
	 * 
	 * @return
	 */
	public Boolean isDatabaseWriterThreadRunnable();

	/**
	 * This will make the databaseWriter thread runnable
	 */
	public void makeDatabaseWriterThreadRunnbale();

	/**
	 * This will make the databaseWriter thread un-runnable
	 */
	public void makeDatabaseWriterThreadUnrunnable();

	// databaseReader
	/**
	 * This will return of the databaseReader thread should run
	 * 
	 * @return
	 */
	public Boolean isDatabaseReaderThreadRunnable();

	/**
	 * This will make the databseReader thread runnable
	 */
	public void makeDatabaseReaderThreadRunnbale();

	/**
	 * This will make the databseReader thread un-runnable
	 */
	public void makeDatabaseReaderThreadUnrunnable();

	// Data for this
	/**
	 * This will write the status of all thread to a redis database
	 * 
	 * @param redis
	 */
	public void writeEntriesToDatabase(IRedisDBInterface redis);

	/**
	 * This will read the status of all threads from a redis database to gain
	 * external control
	 * 
	 * @param redis
	 */
	public void readEntriesFormDatabase(IRedisDBInterface redis);

	/**
	 * This will print the status of all threads to the console
	 */
	public void printAll();

	/**
	 * This is used to read form a properites file
	 */
	public void readPropertiesFile();

	/**
	 * This method can be used to clear the console screen
	 */
	public void clearScreen();

}
