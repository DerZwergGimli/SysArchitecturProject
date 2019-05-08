package main;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;
import accuumulatorSystem.*;

/**
 * The Class Main of the Vehicle Design Init.
 */
public class Main extends Thread {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args){
		Logger LOGGER = setUpLogger();

		System.out.println("-- main method starts --");
		LOGGER.info("-- Application started --");
		
		try {
			// Code in here
			AccumulatorSystem accumulatorSystem_Thread = new AccumulatorSystem();
			accumulatorSystem_Thread.start();
			accumulatorSystem_Thread.setPriority(MAX_PRIORITY);
			accumulatorSystem_Thread.join();
		} catch (InterruptedException e) {
			LOGGER.log(Level.SEVERE, "Error occur in Threads (join).", e);
		}

		LOGGER.info("-- Application closed --");
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
			LOGGER.info("logger stated");
			// LOGGER.setUseParentHandlers(false);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LOGGER;
	}

}
