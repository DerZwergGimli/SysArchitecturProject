package main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import logger.Logging;
import redisInterface.RedisDBInterface;

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
			Logger logger = Logging.setupLogger();
			if (checkForRedisConnection(logger)) {

				Banner.printBanner();
				logger.info("--Application stared--");
				startManager(logger);
				logger.info("---Application closed--");

			} else {
				logger.log(Level.SEVERE, "Cannot connect to Redis-Server you might want to check the config file!");
			}

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
		manager.manage();

	}

	private static Boolean checkForConfigExistance() {
		File f = new File("config_vehicle.properties");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	private static Boolean checkForRedisConnection(Logger logger) {
		RedisDBInterface redis = new RedisDBInterface(logger);

		if (redis.ping(redis)) {
			redis.close();
			return true;

		}
		redis.close();
		return false;

	}

}
