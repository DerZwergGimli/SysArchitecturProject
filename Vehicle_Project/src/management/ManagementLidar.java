package management;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ManagementLidar {

	private Boolean lidarEnabled;
	private String lidarInitCommand;
	private String lidarStartRotationCommand;
	private String lidarStopRotationCommand;
	private String lidarScanCommand;

	public ManagementLidar() {
		readPropertiesFile();
		System.out.println();
	}

	public Boolean isEnabled() {
		return this.lidarEnabled;
	}

	public Boolean init() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("/bin/sh", "-c", lidarInitCommand);

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

				// TODO: Needed Code here to parse the lidar Sensor Data
				System.out.println(lines.toString());
				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return false;

	}

	public Boolean startRotation() {

		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("/bin/sh", "-c", lidarStartRotationCommand);
		String[] lines = new String[4];

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

				// TODO: Needed Code here to parse the lidar Sensor Data
				System.out.println(lines.toString());
				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean stopRotation() {
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("/bin/sh", "-c", lidarStopRotationCommand);

		String[] lines = new String[4];

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

				// TODO: Needed Code here to parse the lidar Sensor Data
				System.out.println(lines.toString());
				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

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

				// TODO: Needed Code here to parse the lidar Sensor Data

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

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
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
