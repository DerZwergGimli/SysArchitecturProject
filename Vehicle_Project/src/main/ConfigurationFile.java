package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is used to manage a configuration file
 * 
 * @author yannick
 *
 */
public class ConfigurationFile {
	/**
	 * This function will check if there is a configuration file present - if not it
	 * will create a new one!
	 * 
	 * @return
	 */
	public static Boolean check() {
		if (checkForConfigExistance()) {
			return true;
		}
		if (!checkForConfigExistance()) {
			System.out.println("Generating a new config file!");
			generateConfig();
			System.out.println("Done Generating a new config file!");
			return true;
		}
		return false;
	}

	private static Boolean checkForConfigExistance() {
		File f = new File("config_vehicle.properties");
		if (f.exists() && !f.isDirectory()) {
			return true;
		}
		return false;
	}

	private static void generateConfig() {
		// Properties prop = new Properties();
		String fileName = "config_vehicle.properties";

		try {
			String configFileString = "Hello";
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			writer.write("#This is the configuration file for the Vehicle-Emulator\n");
			writer.newLine();
			writer.write("#Added a small delay for the banner (s)\n");
			writer.write("banner.delay=0\n");
			writer.write("console.clearScreen=false\n");
			writer.write("console.showStatusInConsole=false\n");
			writer.newLine();
			writer.write("#Should threads be started when the application starts (true/false)\n");
			writer.write(
					"#Note that if you kill the manager the application will completely! You must have to execute the application on your platform again, by calling its binary file.\n");
			writer.write("managementControl.managementThreadRunnable=true\n");
			writer.write("managementControl.collisionAvoidanceThreadRunnable=true\n");
			writer.write("managementControl.lidarDataCollection=true\n");
			writer.write("managementControl.databaseReaderThreadRunnable=false\n");
			writer.write("managementControl.databaseWriterThreadRunnable=true\n");
			writer.write("managementControl.exposeControlToDatabase=true\n");
			writer.newLine();
			writer.write("#CollisionAvoidance\n");
			writer.write("collisonAvoidance.Front_MinDistance=500\n");
			writer.write("collisonAvoidance.FrontLeft_MinDistance=500\n");
			writer.write("collisonAvoidance.FrontRight_MinDistance=500\n");
			writer.write("collisonAvoidance.Left_MinDistance=500\n");
			writer.write("collisonAvoidance.Right_MinDistance=500\n");
			writer.write("collisonAvoidance.Back_MinDistance=500\n");
			writer.write("collisonAvoidance.BackLeft_MinDistance=500\n");
			writer.write("collisonAvoidance.BackRight_MinDistance=500\n");
			writer.write("collisonAvoidance.weighting=1.0\n");
			writer.write("collisonAvoidance.periode=250\n");
			writer.write("collisonAvoidance.cost=100\n");
			writer.write("collisonAvoidance.deadline=200\n");
			writer.newLine();
			writer.write("#Redis-Config\n");
			writer.write("redis.enable=true\n");
			writer.write("redis.url=localhost\n");
			writer.write("redis.port=32769\n");
			writer.write("redis.expireTime=1000\n");
			writer.newLine();
			writer.write("#Lidar-Config\n");
			writer.write("lidar.enabled=false\n");
			writer.write("lidar.initCommand=gpio mode 1 pwm\n");
			writer.write("lidar.startRotationCommand=gpio pwm 1 250\n");
			writer.write("lidar.stopRotationCommand=gpio pwm 1 0\n");
			writer.write("lidar.scanCommand=home/pi/vehicle/lidar/xv11test /dev/ttyAMA0\n");
			writer.write("lidar.periode=2000\n");
			writer.write("lidar.cost=1500\n");
			writer.write("lidar.deadline=1900\n");
			writer.newLine();
			writer.write("#Logger-Config\n");
			writer.write("logger.fileName=vehicleLog.log\n");
			writer.write("logger.maxFileSize=10000\n");
			writer.write("logger.maxNumberOfFiles=3\n");
			writer.write("logger.appendFiles=true\n");
			writer.write("logger.debugLevel=ALL\n");
			writer.newLine();
			writer.write("#NetworkInterface\n");
			writer.write("networkInterface.enabled=true\n");
			writer.write("networkInterface.name=wlp2s0\n");
			writer.newLine();
			writer.write("#Top-Interface\n");
			writer.write("topInterface.enabled=true\n");
			writer.newLine();
			writer.write("#Sensors-Interface\n");
			writer.write("sensorsInterface.enabled=true\n");

			writer.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
