package threads.interruptible;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;

import redis.RedisDBInterface;

public class InterruptableReaderDB implements Interruptible {
	private Logger logger;
	private RedisDBInterface redis;

	public InterruptableReaderDB(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB reader thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		while (true) {
			do {
				redis = new RedisDBInterface(logger);

				System.out.println("Hello from DB-Reader");

				redis.close();
			} while (RealtimeThread.waitForNextPeriod());

		}

	}

}
