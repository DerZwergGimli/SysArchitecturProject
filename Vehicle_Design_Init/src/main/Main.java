package main;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import redis.clients.jedis.Jedis;
import threads.TSystemInfo;
import threads.TWatchdog;

public class Main {

	public static void main(String[] args) {
		Logger LOGGER = setUpLogger();
		LOGGER.info("-- Main started --");

		Jedis jedis = new Jedis("localhost", 32768);
		jedis.set("var1", "100");

		System.out.println(jedis.ping());

		TSystemInfo systemInfoThread = new TSystemInfo();
		systemInfoThread.setName("TSystemInfo");
		systemInfoThread.start();

		TWatchdog watchdogThread = new TWatchdog(systemInfoThread);
		watchdogThread.setName("TWatchdog");
		watchdogThread.start();

		// Map<Thread, StackTraceElement[]> hello = Thread.getAllStackTraces();

		try {
			systemInfoThread.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "Error occur while Threads.join()", e);
		}

		System.out.println("VAR1 = " + jedis.get("var1"));

		jedis.close();

		LOGGER.info("--- Main closed ---");
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