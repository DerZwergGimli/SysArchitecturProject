package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NetworkInterface {

	private String networkInterfaceName = "enp0s3";

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

	public NetworkInterface(String networkInterfaceName) {
		this.networkInterfaceName = networkInterfaceName;

	}

	public void readNetworkInterface() {
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

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
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

}
