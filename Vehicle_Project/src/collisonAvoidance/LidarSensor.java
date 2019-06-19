package collisonAvoidance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import redis.IRedisDBInterface;

public class LidarSensor implements ILidarSensor {

	private static String lidarInitCommand = "gpio mode 1 pwm";
	private static String lidarStartRotationCommand = "gpio pwm 1 300";
	private static String lidarStopRoataionCommand = "gpio pwm 1 0";
	private static String lidarScanCommand = "xv11LidarRunnable /dev/ttyAMA0";

	int expireTimeRedis = 100;

	private String timestamp;
	private int[] angles = new int[360];
	private int[] distances = new int[360];

	public LidarSensor() {
		for (int i = 0; i < angles.length; i++) {
			angles[i] = i;
		}
	}

	public void readDataFromSensor() {
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("bash", "-c", lidarScanCommand);

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

				generateTimestamp();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setRandomDistances() {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = (int) ((Math.random() * 10) + 1);
		}
		generateTimestamp();
	}

	@Override
	public void printValues() {
		for (int i = 0; i < angles.length; i++) {
			System.out.println("Angle=" + angles[i] + "; Distances=" + distances[i]);
		}
	}

	@Override
	public void writeToDB(IRedisDBInterface redis) {
		String parentTopic = "sensors:lidar:";

		redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
		redis.setAndExpire(parentTopic + "distances", distancesToString(), expireTimeRedis);
		redis.setAndExpire(parentTopic + "angles", anglesToString(), expireTimeRedis);
	}

	private String distancesToString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int distance : distances) {
			stringBuilder.append(distance);
			stringBuilder.append(";");
		}
		return stringBuilder.toString();
	}

	private String anglesToString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int angle : angles) {
			stringBuilder.append(angle);
			stringBuilder.append(";");
		}
		return stringBuilder.toString();
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		timestamp = dateFormat.format(new Date());
	}

}
