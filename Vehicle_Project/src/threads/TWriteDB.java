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

import objects.ManagementControl;
import objects.QCollisonControl;
import threads.interruptible.InterruptableWriterDB;

public class TWriteDB extends RealtimeThread {

	Logger logger;
	ManagementControl management;

	// ArrayBlockingQueue<LidarSensor> lidarSensorQueue;
	ArrayBlockingQueue<QCollisonControl> qCollisonControl;
	Boolean running;

	public TWriteDB(Logger logger, ManagementControl management,
			ArrayBlockingQueue<QCollisonControl> qCollisonControl) {
		this.logger = logger;
		this.management = management;
		this.qCollisonControl = qCollisonControl;
		setName("DatabaseWriterThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + 10 - 4;
		SchedulingParameters schedulingParameters = new PriorityParameters(threadPriority);

		ReleaseParameters releaseParameters = new PeriodicParameters(new RelativeTime(), new RelativeTime(1000, 0),
				null, null, null, null);

		setSchedulingParameters(schedulingParameters);
		setReleaseParameters(releaseParameters);

	}

	@Override
	public void run() {

		try {
			logger.info("Creating InterruptableWriterDB");
			AsynchronouslyInterruptedException asInterruptedException = new AsynchronouslyInterruptedException();
			InterruptableWriterDB inWriterDB = new InterruptableWriterDB(logger, management, qCollisonControl);
			asInterruptedException.doInterruptible(inWriterDB);

		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error occured while creating InterruptableWriterDB", e);
		}

	}

}
