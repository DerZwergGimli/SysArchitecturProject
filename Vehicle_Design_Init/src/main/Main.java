package main;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import redis.clients.jedis.Jedis;
import threads.TRealTime;

public class Main {

	public static void main(String[] args) {
		/**
		 * !!! THIS CODE IS STILL UNDER CONSTRUCTION !!!
		 */

		Logger logger = setUpLogger();
		logger.info("-- Main started --");

		Jedis jedis = new Jedis("localhost", 32769);
		jedis.set("var1", "100");
		System.out.println(jedis.ping());

		TRealTime realtimeThread = new TRealTime(logger);
		realtimeThread.setName("TSystemInfo");
		realtimeThread.start();
		while (realtimeThread.isAlive()) {

		}

		long i = 0;
		// for (int i = 0; i < 10000; i++) {
		while (realtimeThread.getState() == Thread.State.RUNNABLE
				|| realtimeThread.getState() == Thread.State.TIMED_WAITING) {
			System.out.println(realtimeThread.getState() + String.valueOf(i));
			i++;

		}
		realtimeThread.interrupt();

		try {
			realtimeThread.join();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error occur while Threads.join()", e);

		}

		System.out.println("VAR1 = " + jedis.get("var1"));

		jedis.close();

		logger.info("--- Main closed ---");
	}

	/**
	 * Sets the up logger.
	 *
	 * @return the logger
	 */
	private static Logger setUpLogger() {
		Logger LOGGER = Logger.getLogger(Main.class.getName());
		FileHandler fh;

		try {
			fh = new FileHandler("mainLog.log", 10000, 3, true);
			LOGGER.addHandler(fh);

			fh.setFormatter(new SimpleFormatter() {
				private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

				@Override
				public synchronized String format(LogRecord lr) {
					return String.format(format, new Date(lr.getMillis()), lr.getLevel().getLocalizedName(),
							lr.getMessage());
				}
			});
			LOGGER.setLevel(Level.ALL);
			LOGGER.info("-- LOGGER stated --");
			// LOGGER.setUseParentHandlers(false);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LOGGER;
	}
}