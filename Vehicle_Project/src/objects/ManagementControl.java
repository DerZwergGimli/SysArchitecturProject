package objects;

import redis.RedisDBInterface;

public class ManagementControl {
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
	public Boolean isManagemnetThreadRunnable() {
		return managementThreadRunnable;
	}

	public void makeManagementThreadRunnable() {
		managementThreadRunnable = true;
	}

	public void makeManegementThreadUnrunnable() {
		managementThreadRunnable = false;
	}

	// CollisionAvoidance
	public Boolean isCollisonAvoidanceThreadRunnable() {
		return collisionAvoidanceThreadRunnable;
	}

	public void makeCollisonAvoidanceThreadRunnable() {
		collisionAvoidanceThreadRunnable = true;
	}

	public void makeCollisonAvoidanceThreadUnrunnable() {
		collisionAvoidanceThreadRunnable = false;
	}

	// databaseWriter
	public Boolean isDatabaseWriterThreadRunnable() {
		return databaseWriterThreadRunnable;
	}

	public void makeDatabaseWriterThreadRunnbale() {
		databaseWriterThreadRunnable = true;
	}

	public void makeDatabaseWriterThreadUnrunnable() {
		databaseWriterThreadRunnable = false;
	}

	// databaseReader
	public Boolean isDatabaseReaderThreadRunnable() {
		return databaseReaderThreadRunnable;
	}

	public void makeDatabaseReaderThreadRunnbale() {
		databaseReaderThreadRunnable = true;
	}

	public void makeDatabaseReaderThreadUnrunnable() {
		databaseReaderThreadRunnable = false;
	}

	public void writeEntriesToDatabase(RedisDBInterface redis) {
		redis.set(parentTopic + "managementRunnable", "true");
		redis.set(parentTopic + "collisonAvoidanceRunnable", "true");
		redis.set(parentTopic + "databaseReaderRunnable", "true");
		redis.set(parentTopic + "databaseWriterRunnable", "true");

		redis.close();
	}

	public void readEntriesFormDatabase(RedisDBInterface redis) {
		managementThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "managementRunnable"));
		collisionAvoidanceThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "collisonAvoidanceRunnable"));
		databaseReaderThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "databaseReaderRunnable"));
		databaseWriterThreadRunnable = Boolean.parseBoolean(redis.get(parentTopic + "databaseWriterRunnable"));

		redis.close();
	}

	public void printAll() {
		System.out.println("managementThreadRunnable:\t\t" + managementThreadRunnable);
		System.out.println("collisionAvoidanceThreadRunnable:\t" + collisionAvoidanceThreadRunnable);
		System.out.println("databaseReaderThreadRunnable:\t\t" + databaseReaderThreadRunnable);
		System.out.println("databaseWriterThreadRunnable:\t\t" + databaseWriterThreadRunnable);
	}

}
