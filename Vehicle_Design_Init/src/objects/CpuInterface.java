package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CpuInterface {
	/**
	 * Since we are using Linux we will look up the following directory: /proc/stat
	 * 
	 * by using: cat "/proc/stat" you will get the following
	 */

	// cpu 2255 34 2290 22625563 6290 127 456
	// cpu0 1132 34 1441 11311718 3675 127 438
	// cpu1 1123 0 849 11313845 2614 0 18
	// intr 114930548 113199788 3 0 5 263 0 4 [... lots more numbers ...]
	// ctxt 1990473
	// btime 1062191376
	// processes 2915
	// procs_running 1
	// procs_blocked 0

	// ENTRY CPU (left to right)
	// user: normal processes executing in user mode
	// nice: niced processes executing in user mode
	// system: processes executing in kernel mode
	// idle: twiddling thumbs
	// iowait: waiting for I/O to complete
	// irq: servicing interrupts
	// softirq: servicing softirqs

	// TODO: LINK ->
	// https://stackoverflow.com/questions/3017162/how-to-get-total-cpu-usage-in-linux-using-c

	private int cpu_user_old;
	private int cpu_nice_old;
	private int cpu_system_old;
	private int cpu_idle_old;
	private int cpu_iowait_old;
	private int cpu_irg_old;
	private int cpu_softirg_old;
	private int cpu_total_jiffes_old; // sum of all values
	private int cpu_work_jiffes_old; // sum of user,nice,system

	private int cpu_user_current;
	private int cpu_nice_current;
	private int cpu_system_current;
	private int cpu_idle_current;
	private int cpu_iowait_current;
	private int cpu_irg_current;
	private int cpu_softirg_current;
	private int cpu_total_jiffes_current; // sum of all values
	private int cpu_work_jiffes_current; // sum of user,nice,system

	private int cpu_usage_percent;

	public CpuInterface() {
		// TODO Auto-generated constructor stub
	}

	private void _readCpuValues() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		String bashString = "cat /proc/stat | grep cpu -m 1";

		processBuilder.command("bash", "-c", bashString);

		String line = "";

		try {
			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			line = reader.readLine();

			int exitCode = process.waitFor();

			if (exitCode == 0) {

				String delims = "[ ]+";
				String[] cpu_tokens = line.split(delims);

				cpu_user_current = Integer.parseInt(cpu_tokens[1]);
				cpu_nice_current = Integer.parseInt(cpu_tokens[2]);
				cpu_system_current = Integer.parseInt(cpu_tokens[3]);
				cpu_idle_current = Integer.parseInt(cpu_tokens[4]);
				cpu_iowait_current = Integer.parseInt(cpu_tokens[5]);
				cpu_irg_current = Integer.parseInt(cpu_tokens[6]);
				cpu_softirg_current = Integer.parseInt(cpu_tokens[7]);

				cpu_total_jiffes_current = cpu_user_current + cpu_nice_current + cpu_system_current + cpu_idle_current
						+ cpu_iowait_current + cpu_irg_current + cpu_softirg_current;

				cpu_work_jiffes_current = cpu_user_current + cpu_nice_current + cpu_system_current;

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void _copyCpuValues() {
		if (cpu_user_current != 0 || cpu_nice_current != 0 || cpu_system_current != 0 || cpu_idle_current != 0
				|| cpu_iowait_current != 0 || cpu_irg_current != 0 || cpu_softirg_current != 0) {

			cpu_user_old = cpu_user_current;
			cpu_nice_old = cpu_nice_current;
			cpu_system_old = cpu_system_current;
			cpu_idle_old = cpu_idle_current;
			cpu_iowait_old = cpu_iowait_current;
			cpu_irg_old = cpu_irg_current;
			cpu_softirg_old = cpu_softirg_current;

			cpu_total_jiffes_old = cpu_total_jiffes_current;
			cpu_work_jiffes_old = cpu_work_jiffes_current;
		}
	}

	public int calculateCpuUsagePercent() {
		_readCpuValues();
		_copyCpuValues();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_readCpuValues();
		int cpu_work_over_periode = cpu_work_jiffes_current - cpu_work_jiffes_old;
		int cpu_total_over_periode = cpu_total_jiffes_current - cpu_total_jiffes_old;
		cpu_usage_percent = (cpu_work_over_periode / cpu_total_over_periode) * 100;

		return cpu_usage_percent;
	}

}
