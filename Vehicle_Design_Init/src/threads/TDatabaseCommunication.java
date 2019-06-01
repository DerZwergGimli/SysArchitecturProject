package threads;

import javax.realtime.PeriodicParameters;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;
import javax.realtime.RelativeTime;

import communicationinterfaces.JedisDBInterface;
import objects.TimingClass;

public class TDatabaseCommunication extends RealtimeThread {

	TimingClass realtimeTiming;
	JedisDBInterface jedisDatabase;

	public TDatabaseCommunication(TimingClass realtimeTiming) {
		this.setName("TDatabaseCommunication");

		int threadPriority = PriorityScheduler.instance().getMinPriority() + (10 - 8);
		PriorityParameters schedulingParameter = new PriorityParameters(threadPriority);
		RelativeTime period = new RelativeTime(100, 0);
		PeriodicParameters releaseParamter = new PeriodicParameters(null, period, null, null, null, null);

		// MemoryParameters memoryParamters = new MemoryParameters(10000, 0);

		this.setSchedulingParameters(schedulingParameter);
		this.setReleaseParameters(releaseParamter);
		// setMemoryParameters(memoryParamters);
		this.realtimeTiming = realtimeTiming;

	}

	@Override
	public void run() {
		while (!this.isInterrupted()) {
			waitForNextPeriod();
			writeToDatabase();
		}
	}

	private void writeToDatabase() {
		if (String.valueOf(realtimeTiming.getDurationNanoSecounds()) != null) {
			jedisDatabase.set("realtimeThreadTimeNano", String.valueOf(realtimeTiming.getDurationNanoSecounds()));
		}

	}

	private void readFromDatabase() {

	}

}
