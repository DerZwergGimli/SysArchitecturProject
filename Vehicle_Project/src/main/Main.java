package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import logger.Logging;

/**
 * This is the main class of the Vehicle
 * 
 * @author yannick
 *
 */
public class Main {

	/**
	 * This is the main function of the vehicle program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Banner.printBanner();

		Logger logger = Logging.setupLogger();
		logger.info("--Application stared--");

		startManager(logger);

		logger.info("---Application closed--");

	}

	/**
	 * This class is used to start and setup the manager
	 * 
	 * @param logger
	 */
	private static void startManager(Logger logger) {
		Manager manager = new Manager(logger);

		manager.start();

		try {
			manager.join();
		} catch (InterruptedException e) {
			logger.log(Level.SEVERE, "Error while trying to joing manager thread the application will colse!");
		}

	}

}
