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

		Logger logger = setupLogger();
		logger.info("-- Main started --");

		ManagementClass management = new ManagementClass(logger);

		while (management.isActive()) {
			management.createAllThreads();
			management.startAllThreads();

			// Just to make sure that we don't get an endless loop...

			management.killAllThreads();
			// management.joinAll();
			management.destroyAllThreads();
			management.kill();
		}

		logger.info("--- Main closed ---");
	}

	/**
	 * Sets the up logger.
	 *
	 * @return the logger
	 */
	private static Logger setupLogger() {
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