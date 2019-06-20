package main;

import java.util.logging.Logger;

import logger.Logging;

public class Main {

	public static void main(String[] args) {
		Banner.printBanner();

		Logger logger = Logging.setupLogger();
		logger.info("--Application stared--");

		startManager(logger);

		logger.info("---Application closed--");

	}

	private static void startManager(Logger logger) {
		Manager manager = new Manager(logger);

		manager.start();

		try {
			manager.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		manager.startThreads();
//		manager.joinThreads();
	}

}
