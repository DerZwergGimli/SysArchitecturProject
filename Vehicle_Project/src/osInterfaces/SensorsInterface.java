package osInterfaces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import redis.IRedisDBInterface;

public class SensorsInterface implements ISensorsInterface {
	private int expireTimeRedis = 100;
	private String cpu0_temperature;

	private String timestamp;

	public SensorsInterface() {

	}

	@Override
	public void readOSSensors() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		String bashString = "sensors | grep 'Core 0'";

		processBuilder.command("bash", "-c", bashString);

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
				String test = lines[0];
				String[] core = test.split("[ ]+");
				cpu0_temperature = core[2].substring(0, core[2].length() - 2);

				generateTimestamp();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void generateTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.GERMANY);
		dateFormat.setTimeZone(TimeZone.getTimeZone("CET"));
		timestamp = dateFormat.format(new Date());
	}

	@Override
	public void writeToDatabase(IRedisDBInterface redis) {
		String parentTopic = "sensors:os:temperatures:";

		redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu0", cpu0_temperature, expireTimeRedis);
		redis.setAndExpire(parentTopic + "unit", "celsius", expireTimeRedis);
	}

}
