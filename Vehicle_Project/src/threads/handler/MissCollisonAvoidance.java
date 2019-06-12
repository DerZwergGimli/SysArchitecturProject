package threads.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;
import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;

public class MissCollisonAvoidance extends AsyncEventHandler {

	AsynchronouslyInterruptedException asInterruptedException;
	RealtimeThread realtimeThread;
	static int priorityParameters = PriorityScheduler.instance().getMinPriority() + 11;
	Logger logger;

	public void setInterruptExeption(AsynchronouslyInterruptedException asInterrupExeption) {
		this.asInterruptedException = asInterrupExeption;

	}

	public void setThread(RealtimeThread realtimeThread) {
		this.realtimeThread = realtimeThread;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public MissCollisonAvoidance() {
		super(new PriorityParameters(priorityParameters), null, null, null, null, null);

	}

	@Override
	public void handleAsyncEvent() {
		logger.log(Level.SEVERE, "Critical the RT Lidar Thread was conuming to much time it will be canceld!");

		realtimeThread.schedulePeriodic();

		if (!asInterruptedException.fire())
			System.out.println("Fire returened false");

	}

}
