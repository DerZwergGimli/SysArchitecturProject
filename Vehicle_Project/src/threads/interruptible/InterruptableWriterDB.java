package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import collisonAvoidance.ICollisonAvoidance;
import gpioInterface.lidar.ILidarSensor;
import management.IManagementControl;
import osInterfaces.INetworkInterface;
import osInterfaces.ISensorsInterface;
import osInterfaces.ITopInterface;
import osInterfaces.NetworkInterface;
import osInterfaces.SensorsInterface;
import osInterfaces.TopInterface;
import redisInterface.IRedisDBInterface;
import redisInterface.RedisDBInterface;
import threads.queue.IQCollisonBuffer;
import timing.IStopWatch;

public class InterruptableWriterDB implements Interruptible {
	private Logger logger;
	private IManagementControl management;
	private IRedisDBInterface redis;
	private ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl;

	public InterruptableWriterDB(Logger logger, IManagementControl management,
			ArrayBlockingQueue<IQCollisonBuffer> qCollisonControl) {
		this.logger = logger;
		this.management = management;
		this.qCollisonControl = qCollisonControl;
		this.redis = new RedisDBInterface(logger);

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB writer thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		while (management.isDatabaseWriterThreadRunnable() && RealtimeThread.waitForNextPeriod()) {

			writeQueueDataToDatabase();
			writeNetworkDataToDatabase();
			writeOSSensorsToDatabase();
			writeLinuxTopInterfaceToDatabase();

		}
		logger.log(Level.WARNING, "DatabaseWriter was exited!");

	}

	private void writeQueueDataToDatabase() {
		// LidarSensor sensorLidar;
		IQCollisonBuffer qCollisonControlObject;

		try {
			qCollisonControlObject = qCollisonControl.poll(10, TimeUnit.MILLISECONDS);
			if (qCollisonControlObject != null) {
				ILidarSensor lidarSensor = qCollisonControlObject.getLidarSensor();
				ICollisonAvoidance collisionAvoidance = qCollisonControlObject.getCollisonAvoidance();
				IStopWatch stopWatch = qCollisonControlObject.getStopWatch();
				lidarSensor.writeToDB(redis);
				stopWatch.writeToDB(redis);
				collisionAvoidance.writeToDB(redis);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Error while trying to get sensorLidarValues form Queue and writing it to the DB",
					e);
		}
		// LidarSensor sensorLidar = lidarSensorQueue.poll();

	}

	private void writeNetworkDataToDatabase() {
		INetworkInterface networkInterface0 = new NetworkInterface();
		networkInterface0.readNetworkInterface();
		networkInterface0.writeToDatabase(redis);
	}

	private void writeOSSensorsToDatabase() {
		ISensorsInterface osSensors = new SensorsInterface();
		osSensors.readOSSensors();
		osSensors.writeToDatabase(redis);
	}

	private void writeLinuxTopInterfaceToDatabase() {
		ITopInterface topInterface = new TopInterface();
		topInterface.readOSLinuxTopInterface();
		topInterface.writeToDatabase(redis);
	}

}
