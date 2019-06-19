package threads.interruptible;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;
import javax.realtime.RealtimeThread;
import javax.realtime.memory.LTMemory;

import management.IManagementControl;
import redis.IRedisDBInterface;
import redis.RedisDBInterface;

public class InterruptableReaderDB implements Interruptible {
	private volatile Logger logger;
	private volatile IManagementControl management;
	private volatile LTMemory ma = null;
	private volatile IRedisDBInterface redis;

	public InterruptableReaderDB(Logger logger, IManagementControl management) {
		this.logger = logger;
		this.management = management;
	}

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		logger.log(Level.WARNING, "DB reader thread was interrupted in its execution");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
//		while (management.isDatabaseReaderThreadRunnable() && RealtimeThread.waitForNextPeriod()) {
//
//			System.out.println("Inside of asMehtode");
//
//			try {
//				ma = new LTMemory(1024 * 1000);
//				if (!(ma instanceof MemoryArea)) {
//					throw new Exception("Return object is not instance of Memory Area");
//				}
//				long size = ma.size();
//				if (size < 0) {
//					throw new Exception("Memeroy size is less than 0");
//				}
//				System.out.println("Successfully created Memeory");
//
//			} catch (Exception e) {
//				System.out.println("Error with memory");
//			}
//			try {
//				ma.enter(new Runnable() {
//
//					@Override
//					public void run() {
//
//						try {
//							// RedisDBInterface redis = new RedisDBInterface(logger);
//
//							System.out.println("Hello from DB-Reader");
//							System.out.println(LTMemory.getMemoryArea(this).memoryRemaining());
//
//							// redis.close();
//							// redis = null;
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							System.out.println("----_ERROR HERE");
//							// e.printStackTrace();
//						}
//
//					}
//				});
//			} catch (Exception e) {
//				System.out.println("enter(Runnable)_failed");
//			}
//		}
//		logger.log(Level.WARNING, "DatabaseReader was exited!");

		while (management.isDatabaseReaderThreadRunnable() && RealtimeThread.waitForNextPeriod()) {

			try {
				IRedisDBInterface redis = new RedisDBInterface(logger);

				System.out.println("Hello from DB-Reader");
				// System.out.println(LTMemory.getMemoryArea(ma).memoryRemaining());

				redis.close();
				// redis = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("----_ERROR HERE");
				// e.printStackTrace();
			}
		}
		logger.log(Level.WARNING, "DatabaseReader was exited!");

	}

}
