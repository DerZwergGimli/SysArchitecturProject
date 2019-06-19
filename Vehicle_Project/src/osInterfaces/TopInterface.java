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

public class TopInterface implements ITopInterface {

	private int expireTimeRedis = 100;

	private String timestamp;
	private String systemTime;
	private String uptime;
	private String uptimeUnit;
	private int users_active;
	private float loadAverage_1min;
	private float loadAverage_5min;
	private float loadAverage_15min;

	private float cpu_user;
	private float cpu_system;
	private float cpu_nice;
	private float cpu_idle;
	private float cpu_wait;
	private float cpu_hardwareInterrupts;
	private float cpu_softwareInterrupts;
	private float cpu_stolenTimeByHypervisor;

	private long memory_total;
	private long memory_free;
	private long memory_used;
	private long memory_bufferCache;
	private String memeory_unit = "KiB";

	private long swap_total;
	private long swap_free;
	private long swap_used;
	private long swap_bufferCache;
	private String swap_unit = "KiB";

	public TopInterface() {
	}

	@Override
	public void readOSLinuxTopInterface() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		String bashString = "top -b -n 1 | grep 'top' -m 1 -A 4";

		processBuilder.command("bash", "-c", bashString);

		String[] lines = new String[5];

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
				// Parse first ROW
				String temp = lines[0];
				String[] firstRow = temp.split("[ ]+");
				if (firstRow.length == 13) {
					systemTime = firstRow[2];
					uptime = firstRow[4];
					uptimeUnit = firstRow[5].substring(0, firstRow[5].length() - 1);
					loadAverage_1min = Float
							.parseFloat(firstRow[10].substring(0, firstRow[10].length() - 1).replace(',', '.'));
					loadAverage_5min = Float
							.parseFloat(firstRow[11].substring(0, firstRow[11].length() - 1).replace(',', '.'));
					loadAverage_15min = Float
							.parseFloat(firstRow[12].substring(0, firstRow[12].length() - 1).replace(',', '.'));
				}
				if (firstRow.length == 12) {
					systemTime = firstRow[2];
					uptime = firstRow[4].substring(0, firstRow[4].length() - 1);
					uptimeUnit = "hh:mm";
					loadAverage_1min = Float
							.parseFloat(firstRow[9].substring(0, firstRow[9].length() - 1).replace(',', '.'));
					loadAverage_5min = Float
							.parseFloat(firstRow[10].substring(0, firstRow[10].length() - 1).replace(',', '.'));
					loadAverage_15min = Float
							.parseFloat(firstRow[11].substring(0, firstRow[11].length() - 1).replace(',', '.'));
				}

				// Parse secound ROW TODO: make this happening
				temp = lines[1];
				String[] secoundRow = temp.split("[ ]+");

				// Parse third ROW
				temp = lines[2];
				String[] thridRow = temp.split("[ ]+");
				cpu_user = Float.parseFloat(thridRow[1].replace(',', '.'));
				cpu_system = Float.parseFloat(thridRow[3].replace(',', '.'));
				cpu_nice = Float.parseFloat(thridRow[5].replace(',', '.'));
				cpu_idle = Float.parseFloat(thridRow[7].replace(',', '.'));
				cpu_wait = Float.parseFloat(thridRow[9].replace(',', '.'));
				cpu_hardwareInterrupts = Float.parseFloat(thridRow[11].replace(',', '.'));
				cpu_softwareInterrupts = Float.parseFloat(thridRow[13].replace(',', '.'));
				cpu_stolenTimeByHypervisor = Float.parseFloat(thridRow[15].replace(',', '.'));

				// Parse fourth ROW
				temp = lines[3];
				String[] fourthRow = temp.split("[ ]+");
				memory_total = Long.parseLong(fourthRow[3]);
				memory_free = Long.parseLong(fourthRow[5]);
				memory_used = Long.parseLong(fourthRow[7]);
				memory_bufferCache = Long.parseLong(fourthRow[9]);

				// Parse fifth ROW
				temp = lines[4];
				String[] fifthRow = temp.split("[ ]+");
				swap_total = Long.parseLong(fifthRow[2]);
				swap_free = Long.parseLong(fifthRow[4]);
				swap_used = Long.parseLong(fifthRow[6]);
				swap_bufferCache = Long.parseLong(fifthRow[8]);

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
		String parentTopic = "sensors:os:top:";
		redis.setAndExpire(parentTopic + "timestamp", timestamp, expireTimeRedis);
		redis.setAndExpire(parentTopic + "systemTime", systemTime, expireTimeRedis);
		redis.setAndExpire(parentTopic + "uptime", uptime, expireTimeRedis);
		redis.setAndExpire(parentTopic + "uptimeUnit", uptimeUnit, expireTimeRedis);
		redis.setAndExpire(parentTopic + "users_active", String.valueOf(users_active), expireTimeRedis);
		redis.setAndExpire(parentTopic + "loadAverage_1min", String.valueOf(loadAverage_1min), expireTimeRedis);
		redis.setAndExpire(parentTopic + "loadAverage_5min", String.valueOf(loadAverage_5min), expireTimeRedis);
		redis.setAndExpire(parentTopic + "loadAverage_15min", String.valueOf(loadAverage_15min), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_user", String.valueOf(cpu_user), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_system", String.valueOf(cpu_system), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_nice", String.valueOf(cpu_nice), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_idle", String.valueOf(cpu_idle), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_wait", String.valueOf(cpu_wait), expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_hardwareInterrupts", String.valueOf(cpu_hardwareInterrupts),
				expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_softwareInterrupts", String.valueOf(cpu_softwareInterrupts),
				expireTimeRedis);
		redis.setAndExpire(parentTopic + "cpu_stolenTimeByHypervisor", String.valueOf(cpu_stolenTimeByHypervisor),
				expireTimeRedis);
		redis.setAndExpire(parentTopic + "memory_total", String.valueOf(memory_total), expireTimeRedis);
		redis.setAndExpire(parentTopic + "memory_free", String.valueOf(memory_free), expireTimeRedis);
		redis.setAndExpire(parentTopic + "memory_used", String.valueOf(memory_used), expireTimeRedis);
		redis.setAndExpire(parentTopic + "memory_bufferCache", String.valueOf(memory_bufferCache), expireTimeRedis);
		redis.setAndExpire(parentTopic + "memeory_unit", memeory_unit, expireTimeRedis);
		redis.setAndExpire(parentTopic + "swap_total", String.valueOf(swap_total), expireTimeRedis);
		redis.setAndExpire(parentTopic + "swap_free", String.valueOf(swap_free), expireTimeRedis);
		redis.setAndExpire(parentTopic + "swap_used", String.valueOf(swap_used), expireTimeRedis);
		redis.setAndExpire(parentTopic + "swap_bufferCache", String.valueOf(swap_bufferCache), expireTimeRedis);
		redis.setAndExpire(parentTopic + "swap_unit", swap_unit, expireTimeRedis);

	}

}
