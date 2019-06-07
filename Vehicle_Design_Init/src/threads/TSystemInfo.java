package threads;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import operatingSystemInterfaces.CpuInterface;
import operatingSystemInterfaces.NetworkInterface;

public class TSystemInfo extends RealtimeThread {

	private boolean isRunning;

	NetworkInterface networkInterface;
	CpuInterface cpuInterface;

	public TSystemInfo(NetworkInterface networkInterface) {
		this.setName("SystemInfoThread");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + (10 - 8);
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(500, 0);
		PeriodicParameters releaseParamter = new PeriodicParameters(null, period, null, null, null, null);

		// MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		this.setSchedulingParameters(schedulingParameter);
		this.setReleaseParameters(releaseParamter);
		// setMemoryParameters(memoryParamters);
		// this.running = running;

		this.networkInterface = networkInterface;

	}

	@Override
	public void run() {
		while (!isInterrupted() && isRunning) {
			waitForNextPeriod();
			networkInterface.readNetworkInterface();

		}
	}

	public void kill() {
		this.isRunning = false;
	}

}
