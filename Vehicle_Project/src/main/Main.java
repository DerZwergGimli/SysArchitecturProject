package main;

import java.io.File;
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
		if (checkForConfigExistance()) {
			Banner.printBanner();

			Logger logger = Logging.setupLogger();
			logger.info("--Application stared--");

			startManager(logger);

			logger.info("---Application closed--");
		} else {
			System.out.println("Error while trying to find config file!");
			System.out.println("Make sure that you have a valid config file!");
		}
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

	private static Boolean checkForConfigExistance() {
		File f = new File("config.properties");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

}
