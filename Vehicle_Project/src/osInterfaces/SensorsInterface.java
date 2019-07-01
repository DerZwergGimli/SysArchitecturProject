package osInterfaces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

import redisInterface.IRedisDBInterface;

public class SensorsInterface implements ISensorsInterface {
	private Boolean enabled;
	private int expireTimeRedis = 100;
	private String cpu0_temperature;

	private String timestamp;

	public SensorsInterface() {
		readPropertiesFile();
	}

	@Override
	public void readOSSensors() {
		if (enabled) {

			ProcessBuilder processBuilder = new ProcessBuilder();
			String bashString = "cat /sys/class/thermal/thermal_zone0/temp";

			processBuilder.command("/bin/bash", "-c", bashString);

			String[] lines = new String[1];

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
					float temperature = Float.valueOf(lines[0]) / 1000;
					cpu0_temperature = String.valueOf(temperature);

					generateTimestamp();
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		timestamp = dateFormat.format(new Date());
	}

	@Override
	public void writeToDatabase(IRedisDBInterface redis) {
		if (enabled) {

			String parentTopic = "sensors:os:temperature:";

			redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
			redis.setAndExpire(parentTopic + "cpu0", cpu0_temperature, expireTimeRedis);
			redis.setAndExpire(parentTopic + "unit", "celsius", expireTimeRedis);
		}
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config_vehicle.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			enabled = Boolean.valueOf(properties.getProperty("sensorsInterface.enabled"));
			expireTimeRedis = Integer.valueOf(properties.getProperty("redis.expireTime"));

		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}

}
