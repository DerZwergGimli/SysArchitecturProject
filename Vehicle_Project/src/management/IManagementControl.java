package management;

import redis.IRedisDBInterface;

public interface IManagementControl {
	// Management
	public Boolean isManagemnetThreadRunnable();

	public void makeManagementThreadRunnable();

	public void makeManegementThreadUnrunnable();

	// CollisionAvoidance
	public Boolean isCollisonAvoidanceThreadRunnable();

	public void makeCollisonAvoidanceThreadRunnable();

	public void makeCollisonAvoidanceThreadUnrunnable();

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

}
