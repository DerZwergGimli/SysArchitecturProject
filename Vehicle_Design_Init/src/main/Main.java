package main;

import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import objects.ManagementClass;

public class Main {

	public static void main(String[] args) {
		/**
		 * !!! THIS CODE IS STILL UNDER CONSTRUCTION !!!
		 */

		Logger logger = setUpLogger();
		logger.info("-- Main started --");

		ManagementClass management = new ManagementClass(logger);

		while (management.isRunning()) {
			management.startAllThreads();

			// Just to make sure that we don't get an endless loop...
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			management.killAllThreads();
			management.kill();
		}

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