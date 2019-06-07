package main;

import java.util.logging.Logger;

import logger.Logging;
import objects.ManagementClass;

public class Main {

	public static void main(String[] args) {
		/**
		 * !!! THIS CODE IS STILL UNDER CONSTRUCTION !!!
		 */

		Logger logger = Logging.setupLogger();
		logger.info("-- Main started --");

		ManagementClass management = new ManagementClass(logger);

		while (management.isActive()) {
			management.createAllThreads();
			management.startAllThreads();

			// Just to make sure that we don't get an endless loop...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			management.killAllThreads();
			// management.joinAll();
			management.destroyAllThreads();
			management.kill();
		}

		logger.info("--- Main closed ---");
	}

}