package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;
import javax.realtime.ReleaseParameters;
import javax.realtime.SchedulingParameters;

import objects.LidarSensor;
import objects.ManagementControl;
import threads.interruptible.InterruptableWriterDB;

public class TWriteDB extends RealtimeThread {

	Logger logger;
	ManagementControl management;

	ArrayBlockingQueue<LidarSensor> lidarSensorQueue;
	Boolean running;

	public TWriteDB(Logger logger, ManagementControl management, ArrayBlockingQueue<LidarSensor> lidarSensorQueue) {
		this.logger = logger;
		this.management = management;
		this.lidarSensorQueue = lidarSensorQueue;
		setName("DatabaseWriterThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 4;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(300, 0), null,
				null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	@Override
	public void run() {

		try {
			logger.info("Creating InterruptableWriterDB");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptableWriterDB inWriterDB = new InterruptableWriterDB(logger, management, lidarSensorQueue);
			asInterruptedException.doInterruptible(inWriterDB);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableWriterDB", e);
		}

	}

}
