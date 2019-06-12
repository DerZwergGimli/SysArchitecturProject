package os;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import redis.RedisDBInterface;

public class OSSensorInterface {
	private int expireTimeRedis = 100;
	private String cpu0_temperature;

	public OSSensorInterface() {
		// TODO Auto-generated constructor stub
	}

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
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void writeToDatabase(RedisDBInterface redis) {
		String parentTopic = "sensors:os:temperatures:";
		redis.setAndExpire(parentTopic + "cpu0", cpu0_temperature, expireTimeRedis);
		redis.setAndExpire(parentTopic + "unit", "celsius", expireTimeRedis);
	}

}
