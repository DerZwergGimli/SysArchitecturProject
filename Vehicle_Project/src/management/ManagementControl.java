package management;

import redis.IRedisDBInterface;

public class ManagementControl implements IManagementControl {
	private static String parentTopic = "management:threads:";

	private Boolean managementThreadRunnable;
	private Boolean collisionAvoidanceThreadRunnable;
	private Boolean databaseWriterThreadRunnable;
	private Boolean databaseReaderThreadRunnable;

	public ManagementControl() {
//		managementThreadRunnable = true;
//		collisionAvoidanceThreadRunnable = true;
//		databaseWriterThreadRunnable = true;
//		databaseReaderThreadRunnable = true;
	}

	public ManagementControl(Boolean managementActive, Boolean databaseWriterActive, Boolean databaseReaderAvtive) {
		this.managementThreadRunnable = managementActive;
		this.databaseWriterThreadRunnable = databaseWriterActive;
		this.databaseReaderThreadRunnable = databaseReaderAvtive;
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
		redis.set(parentTopic + "managementRunnable", "true");
		redis.set(parentTopic + "collisonAvoidanceRunnable", "true");
		redis.set(parentTopic + "databaseReaderRunnable", "true");
		redis.set(parentTopic + "databaseWriterRunnable", "true");

		redis.close();
	}

	@Override
	public void readEntriesFormDatabase(IRedisDBInterface redis) {
		managementThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "managementRunnable"));
		collisionAvoidanceThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "collisonAvoidanceRunnable"));
		databaseReaderThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "databaseReaderRunnable"));
		databaseWriterThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "databaseWriterRunnable"));

		redis.close();
	}

	@Override
	public void printAll() {
		System.out.println("managementThreadRunnable:\t\t" + managementThreadRunnable);
		System.out.println("collisionAvoidanceThreadRunnable:\t" + collisionAvoidanceThreadRunnable);
		System.out.println("databaseReaderThreadRunnable:\t\t" + databaseReaderThreadRunnable);
		System.out.println("databaseWriterThreadRunnable:\t\t" + databaseWriterThreadRunnable);
	}

}
