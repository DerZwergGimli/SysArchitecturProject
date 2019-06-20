package main;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Banner {

	private static int startupDelay = 5;

	public static void printBanner() {
		readPropertiesFile();

		System.out.println(" _    _         __      __  _     _      _      _____           _           _   ");
		System.out.println("| |  | |        \\ \\    / / | |   (_)    | |    |  __ \\         (_)         | |  ");
		System.out.println("| |__| |         \\ \\  / /__| |__  _  ___| | ___| |__) | __ ___  _  ___  ___| |_ ");
		System.out.println("|  __  |          \\ \\/ / _ \\ '_ \\| |/ __| |/ _ \\  ___/ '__/ _ \\| |/ _ \\/ __| __|");
		System.out.println("| |  | |           \\  /  __/ | | | | (__| |  __/ |   | | | (_) | |  __/ (__| |_ ");
		System.out.println("|_|  |_|            \\/ \\___|_| |_|_|\\___|_|\\___|_|   |_|  \\___/| |\\___|\\___|\\__|");
		System.out.println("                                                              _/ |              ");
		System.out.println("                                                             |__/               ");
		System.out.println(" _______           _____ _____ ___   ___  __  ___                               ");
		System.out.println("|__   __|         / ____/ ____|__ \\ / _ \\/_ |/ _ \\                              ");
		System.out.println("   | |           | (___| (___    ) | | | || | (_) |                             ");
		System.out.println("   | |            \\___ \\\\___ \\  / /| | | || |\\__, |                             ");
		System.out.println("   | |            ____) |___) |/ /_| |_| || |  / /                              ");
		System.out.println("   |_|           |_____/_____/|____|\\___/ |_| /_/                               ");
		System.out.println("                                                                                ");
		System.out.println("__          __         ______ _____ ____                                        ");
		System.out.println("\\ \\        / /        |  ____|_   _|  _ \\                                       ");
		System.out.println(" \\ \\  /\\  / /         | |__    | | | |_) |                                      ");
		System.out.println("  \\ \\/  \\/ /          |  __|   | | |  _ <                                       ");
		System.out.println("   \\  /\\  /           | |____ _| |_| |_) |                                      ");
		System.out.println("    \\/  \\/            |______|_____|____/                                       ");
		System.out.println("                                                                                ");
		System.out.println("  _____                                                                         ");
		System.out.println(" / ____|          Project-Members:                                              ");
		System.out.println("| |  __               - Jonas Maier                                             ");
		System.out.println("| | |_ |              - Mouaad Gasair                                           ");
		System.out.println("| |__| |              - Yannick Pauly                                           ");
		System.out.println(" \\_____|                             		HOPE YOU ENJOY THIS!        ");
		System.out.println();
		System.out.println();
		try {
			Thread.sleep(startupDelay);
		} catch (InterruptedException e) {
		}

	}

	private static void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			startupDelay = Integer.valueOf(properties.getProperty("banner.delay")) * 1000;
		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}

	}

}
