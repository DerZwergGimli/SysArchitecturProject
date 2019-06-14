package threads.interruptible;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import objects.ManagementControl;
import redis.RedisDBInterface;

public class InterruptableReaderDB implements Interruptible {
	private Logger logger;
	private ManagementControl management;
	private RedisDBInterface redis;

	public InterruptableReaderDB(Logger logger, ManagementControl management) {
		this.logger = logger;
		this.management = management;
	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB reader thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		while (management.isDatabaseReaderThreadRunnable() && RealtimeThread.waitForNextPeriod()) {

			redis = new RedisDBInterface(logger);

			System.out.println("Hello from DB-Reader");

			redis.close();

		}
		logger.log(Level.WARNING, "DatabaseReader was exited!");

	}

}
