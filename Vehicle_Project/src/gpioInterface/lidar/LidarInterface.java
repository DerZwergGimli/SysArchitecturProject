package gpioInterface.lidar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Implementation of a ILidarInterface used to control a lidar-sensor on an RPI
 * 
 * @author yannick
 *
 */
public class LidarInterface implements ILidarInterface {

	private Boolean lidarEnabled;
	private String lidarInitCommand;
	private String lidarStartRotationCommand;
	private String lidarStopRotationCommand;
	private String lidarScanCommand;

	/**
	 * The constructor for a LidarInterface
	 */
	public LidarInterface() {
		readPropertiesFile();
	}

	@Override
	public Boolean isEnabled() {
		return this.lidarEnabled;
	}

	@Override
	public Boolean init() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("/bin/sh", "-c", lidarInitCommand);

		try {
			Process process = processBuilder.start();

			int exitCode = process.waitFor();

			if (exitCode == 0) {

				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public Boolean startRotation() {

		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("/bin/sh", "-c", lidarStartRotationCommand);

		try {
			Process process = processBuilder.start();

			int exitCode = process.waitFor();

			if (exitCode == 0) {

				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean stopRotation() {
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("/bin/sh", "-c", lidarStopRotationCommand);

		try {
			Process process = processBuilder.start();

			int exitCode = process.waitFor();

			if (exitCode == 0) {

				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int[] scan() {
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("/bin/sh", "-c", lidarScanCommand);

		String[] lines = new String[2];

		try {
			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			int i = 0;

			while ((line = reader.readLine()) != null) {
				lines[i] = line;
				i++;
			}

			int exitCode = process.waitFor();

			if (exitCode == 0) {

				String valuesString[] = lines[1].split(";");
				int valuesInt[] = new int[360];
				for (int j = 0; j < valuesString.length - 1; j++) {
					valuesInt[j] = Integer.valueOf(valuesString[j]);
				}

				return valuesInt;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new int[0];
	}

	@Override
	public int[] generateRandomDistances() {
		int[] distances = new int[360];
		for (int i = 0; i < distances.length; i++) {
			distances[i] = (int) ((Math.random() * 10) + 1);
		}
		return distances;
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config_vehicle.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			this.lidarEnabled = Boolean.valueOf(properties.getProperty("lidar.enabled"));
			this.lidarInitCommand = properties.getProperty("lidar.initCommand");
			this.lidarStartRotationCommand = properties.getProperty("lidar.startRotationCommand");
			this.lidarStopRotationCommand = properties.getProperty("lidar.stopRotationCommand");
			this.lidarScanCommand = properties.getProperty("lidar.scanCommand");
		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}
}
