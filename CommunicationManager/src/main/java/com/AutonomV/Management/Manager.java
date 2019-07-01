package com.AutonomV.Management;


import com.AutonomV.Communication.ComController;
import com.AutonomV.Communication.DBController;
import com.AutonomV.Util.Banner;
import com.AutonomV.Util.Logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Class is managing class of the application, it contains the main function.
 *
 * @author Mgsair
 */
public class Manager {
    private static String mqttURL;
    private static String mqttPort;
    private static String mqttClientID;
    private static String mqttUsername;
    private static String mqttPassword;
    private static String mqttSubTopic;

    private static String redisHost;
    private static int redisPort;

    private static Logger logger;

    /**
     *  This is the Main function acting as en entry of the application
     * @param args
     */
    public static void main(String[] args) {

        Banner.printBanner();

        if (checkForConfigExistance()) {
            logger = Logging.setupLogger();
        } else {
            System.out.println("Error while trying to find config file!");
            System.out.println("Make sure that you have a valid config file!");
        }

        readPropertiesFile();

        logger.info("Initiating the Instances");
        DBController.init(redisHost, redisPort, 100, logger);

        ComController comController = new ComController("ea-pc165.ei.htwg-konstanz.de", "8883", "Autonom-V1");

        DataPersistanceThread dataPersistanceThread = new DataPersistanceThread(5000, comController, logger);
        dataPersistanceThread.initProperties();

        ManagementThread managementThread = new ManagementThread(comController, logger);
        comController.init("/SysArch/V1/Driver/AuthResponse/", true, "V1", "DE1");

        logger.info("Starting the Threads");
        managementThread.start();
        dataPersistanceThread.start();

    }

    private static void readPropertiesFile() {
        try (InputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            mqttURL = properties.getProperty("mqtt.url", "ea-pc165.ei.htwg-konstanz.de");
            mqttPort = properties.getProperty("mqtt.port", "8883");
            mqttClientID = properties.getProperty("mqtt.clientID", "Autonom-V1");
            mqttUsername = properties.getProperty("mqtt.user", "V1");
            mqttPassword = properties.getProperty("mqtt.password", "DE1");
            mqttSubTopic = properties.getProperty("mqtt.subTopic", "/SysArch/V1/Driver/AuthResponse/");

            redisHost = properties.getProperty("redis.url", "localhost");
            redisPort = Integer.valueOf(properties.getProperty("redis.port", "6379"));

        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error while trying to read config of RedisDB", ex);
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