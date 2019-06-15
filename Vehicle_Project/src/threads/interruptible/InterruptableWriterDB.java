package threads.interruptible;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.LidarSensor;
import objects.ManagementControl;
import objects.QCollisonControl;
import objects.StopWatch;
import os.NetworkInterface;
import os.OSLinuxTopInterface;
import os.OSSensorInterface;
import redis.RedisDBInterface;

public class InterruptableWriterDB implements Interruptible {
	private Logger logger;
	private ManagementControl management;
	private RedisDBInterface redis;
	private ArrayBlockingQueue<QCollisonControl> qCollisonControl;

	public InterruptableWriterDB(Logger logger, ManagementControl management,
			ArrayBlockingQueue<QCollisonControl> qCollisonControl) {
		this.logger = logger;
		this.management = management;
		this.qCollisonControl = qCollisonControl;

	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB writer thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		while (management.isDatabaseWriterThreadRunnable() && RealtimeThread.waitForNextPeriod()) {

			System.out.println("Hello from Writer");
			redis = new RedisDBInterface(logger);
			writeQueueDataToDatabase();
			writeNetworkDataToDatabase();
			writeOSSensorsToDatabase();
			writeLinuxTopInterfaceToDatabase();

			redis.close();

		}
		logger.log(Level.WARNING, "DatabaseWriter was exited!");

	}

	private void writeQueueDataToDatabase() {
		// LidarSensor sensorLidar;
		QCollisonControl qCollisonControlObject;

		try {
			qCollisonControlObject = qCollisonControl.poll(10, TimeUnit.MILLISECONDS);
			if (qCollisonControlObject != null) {
				LidarSensor lidarSensor = qCollisonControlObject.getLidarSensor();
				StopWatch stopWatch = qCollisonControlObject.getStopWatch();
				lidarSensor.writeToDB(redis);
				stopWatch.writeToDB(redis);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "Error while trying to get sensorLidarValues form Queue and writing it to the DB",
					e);
		}
		// LidarSensor sensorLidar = lidarSensorQueue.poll();

	}

	private void writeNetworkDataToDatabase() {
		NetworkInterface networkInterface0 = new NetworkInterface("wlp2s0");
		networkInterface0.readNetworkInterface();
		networkInterface0.writeToDatabase(redis);
	}

	private void writeOSSensorsToDatabase() {
		OSSensorInterface osSensors = new OSSensorInterface();
		osSensors.readOSSensors();
		osSensors.writeToDatabase(redis);
	}

	private void writeLinuxTopInterfaceToDatabase() {
		OSLinuxTopInterface topInterface = new OSLinuxTopInterface();
		topInterface.readOSLinuxTopInterface();
		topInterface.writeToDatabase(redis);
	}

}
