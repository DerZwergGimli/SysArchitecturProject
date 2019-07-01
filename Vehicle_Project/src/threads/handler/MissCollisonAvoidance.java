package threads.handler;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.realtime.AsyncEventHandler;
import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.PriorityParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.RealtimeThread;

/**
 * Concrete MissHandler for the collisionAvoidance
 * 
 * @author yannick
 *
 */
public class MissCollisonAvoidance extends AsyncEventHandler implements IMissHandler {

	AsynchronouslyInterruptedException asInterruptedException;
	RealtimeThread realtimeThread;
	static int priorityParameters = PriorityScheduler.instance().getMinPriority() + 11;
	Logger logger;

	@Override
	public void setInterruptExeption(AsynchronouslyInterruptedException asInterrupExeption) {
		this.asInterruptedException = asInterrupExeption;

	}

	@Override
	public void setThread(RealtimeThread realtimeThread) {
		this.realtimeThread = realtimeThread;
	}

	@Override
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * Constructor for a MissHandler for CollisonAvoidance
	 * 
	 * @param logger
	 */
	public MissCollisonAvoidance(Logger logger) {
		super(new PriorityParameters(priorityParameters), null, null, null, null, null);
		this.logger = logger;

	}

	@Override
	public void handleAsyncEvent() {
		logger.log(Level.SEVERE,
				"Critical the RT Collision Avoidance Thread was conuming to much time it will be canceld!");

		realtimeThread.schedulePeriodic();

		if (!asInterruptedException.fire())
			System.out.println("Fire returened false");

	}

}
