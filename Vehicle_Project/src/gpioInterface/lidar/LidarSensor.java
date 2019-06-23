package gpioInterface.lidar;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import redisInterface.IRedisDBInterface;

public class LidarSensor implements ILidarSensor {
	int expireTimeRedis = 100;

	private String timestamp;
	private int[] angles = new int[360];
	private int[] distances = new int[360];

	public LidarSensor() {
		readPropertiesFile();
		generateAngels();
	}

	private void generateAngels() {
		for (int i = 0; i < angles.length; i++) {
			angles[i] = i;
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
	public void setDistances(int[] distances) {
		this.distances = distances;
		generateTimestamp();
	}

	@Override
	public int[] getDistancesBySection(int startAngle, int endAngle) {
		int[] distancesSection = null;

		if ((endAngle - startAngle) > 0) {
			distancesSection = new int[endAngle - startAngle];

			for (int i = startAngle; i < endAngle; i++) {
				distancesSection[i - startAngle] = distances[i];
			}
		}

		if ((startAngle - endAngle) > 0) {
			int startToZero = 359 - startAngle;

			distancesSection = new int[startToZero + endAngle + 1];
			for (int i = startAngle; i < distances.length; i++) {
				distancesSection[i - startAngle] = distances[i];
			}

			for (int i = 0; i < endAngle; i++) {
				distancesSection[startToZero + i + 1] = distances[i];
			}
		}

		return distancesSection;
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

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			expireTimeRedis = Integer.valueOf(properties.getProperty("redis.expireTime"));

		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}

}
