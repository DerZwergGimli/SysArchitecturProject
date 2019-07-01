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

public class NetworkInterface implements INetworkInterface {
	private Boolean enabled;

	private int expireTimeRedis = 100;

	private String networkInterfaceName;

	private String timestamp;
	private long rx_bytes;
	private long rx_packages;
	private long rx_errors;
	private long rx_dropped;
	private long rx_overrun;
	private long rx_mcast;

	private long tx_bytes;
	private long tx_packages;
	private long tx_errors;
	private long tx_dropped;
	private long tx_carrier;
	private long tx_collsns;

	public NetworkInterface() {
		readPropertiesFile();

	}

	@Override
	public void readNetworkInterface() {
		if (enabled) {

			ProcessBuilder processBuilder = new ProcessBuilder();
			String bashString = "ip -statistics link show dev " + this.networkInterfaceName + " | grep RX -A 4";

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
					if (!lines[0].contains("does not exist")) {
						String delims = "[ ]+";
						String[] rx_tokens = lines[1].split(delims);
						String[] tx_tokens = lines[3].split(delims);

						this.rx_bytes = Long.parseLong(rx_tokens[1]);
						this.rx_packages = Long.parseLong(rx_tokens[2]);
						this.rx_errors = Long.parseLong(rx_tokens[3]);
						this.rx_dropped = Long.parseLong(rx_tokens[4]);
						this.rx_overrun = Long.parseLong(rx_tokens[5]);
						this.rx_mcast = Long.parseLong(rx_tokens[6]);

						this.tx_bytes = Long.parseLong(tx_tokens[1]);
						this.tx_packages = Long.parseLong(tx_tokens[2]);
						this.tx_errors = Long.parseLong(tx_tokens[3]);
						this.tx_dropped = Long.parseLong(tx_tokens[4]);
						this.tx_carrier = Long.parseLong(tx_tokens[5]);
						this.tx_collsns = Long.parseLong(tx_tokens[6]);

						generateTimestamp();

					}

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

			String parentTopic = "sensors:os:network:";
			redis.setAndExpire(parentTopic + networkInterfaceName + ":timestamp", timestamp, expireTimeRedis);

			// Set ALL RX_Values
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_bytes", String.valueOf(rx_bytes),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_packages", String.valueOf(rx_packages),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_errors", String.valueOf(rx_errors),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_dropped", String.valueOf(rx_dropped),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_overrun", String.valueOf(rx_overrun),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":rx_mcast", String.valueOf(rx_mcast),
					expireTimeRedis);

			// Set ALL RX_Values
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_bytes", String.valueOf(tx_bytes),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_packages", String.valueOf(tx_packages),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_errors", String.valueOf(tx_errors),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_droppped", String.valueOf(tx_dropped),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_carrier", String.valueOf(tx_carrier),
					expireTimeRedis);
			redis.setAndExpire(parentTopic + networkInterfaceName + ":tx_collsns", String.valueOf(tx_collsns),
					expireTimeRedis);
		}
	}

	@Override
	public String toString() {
		return "NetworkInterface \n[networkInterfaceName=" + networkInterfaceName + "\n " + "rx_bytes=" + rx_bytes
				+ ", rx_packages=" + rx_packages + ", rx_errors=" + rx_errors + ", rx_dropped=" + rx_dropped
				+ ", rx_overrun=" + rx_overrun + ", rx_mcast=" + rx_mcast + "\n tx_bytes=" + tx_bytes + ", tx_packages="
				+ tx_packages + ", tx_errors=" + tx_errors + ", tx_dropped=" + tx_dropped + ", tx_carrier=" + tx_carrier
				+ ", tx_collsns=" + tx_collsns + "]";
	}

	private void readPropertiesFile() {
		try (InputStream input = new FileInputStream("config_vehicle.properties")) {
			Properties properties = new Properties();
			properties.load(input);

			enabled = Boolean.valueOf(properties.getProperty("networkInterface.enabled"));
			networkInterfaceName = properties.getProperty("networkInterface.name");
			expireTimeRedis = Integer.valueOf(properties.getProperty("redis.expireTime"));

		} catch (Exception ex) {
			System.out.println("Error reading config file!");

		}
	}

}
