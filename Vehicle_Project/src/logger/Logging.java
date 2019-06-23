package logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import main.Main;

/**
 * This is the logging class to log some information to the console and file
 * 
 * @author yannick
 *
 */
public class Logging {
	/**
	 * Sets the up logger.
	 *
	 * @return the logger
	 */
	private static Logger LOGGER;
	private static String fileName;
	private static int maxFileSize;
	private static int maxNumberOfFiles;
	private static Boolean appendFiles;
	private static Level debugLevel;

	/**
	 * This will create the logger-instance
	 * 
	 * @return
	 */
	public static Logger setupLogger() {
		LOGGER = Logger.getLogger(Main.class.getName());
		FileHandler fh;

		readPropertiesFile();

		try {
			fh = new FileHandler(fileName, maxFileSize, maxNumberOfFiles, appendFiles);
			LOGGER.addHandler(fh);

			fh.setFormatter(new SimpleFormatter() {
				private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s%n %4$s %n";

				@Override
				public synchronized String format(LogRecord lr) {
					return String.format(format, new Date(lr.getMillis()), lr.getLevel().getLocalizedName(),
							lr.getMessage(), lr.getThrown());
				}
			});
			LOGGER.setLevel(debugLevel);
			LOGGER.info("-- LOGGER stated --");
			// LOGGER.setUseParentHandlers(false);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return LOGGER;
	}

	private static void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			fileName = properties.getProperty("logger.fileName");
			maxFileSize = Integer.valueOf(properties.getProperty("logger.maxFileSize"));
			maxNumberOfFiles = Integer.valueOf(properties.getProperty("logger.maxNumberOfFiles"));
			appendFiles = Boolean.valueOf(properties.getProperty("logger.maxNumberOfFiles"));
			debugLevel = Level.parse(properties.getProperty("logger.debugLevel"));

		} catch (Exception ex) {
			System.out.println("Error while trying to read config for Logger!!! ");

		}
	}

}
