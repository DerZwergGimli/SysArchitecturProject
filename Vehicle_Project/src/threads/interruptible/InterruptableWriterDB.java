package threads.interruptible;

import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.Interruptible;

public class InterruptableWriterDB implements Interruptible {
	private Logger logger;

	@Override
	public void interruptAction(AsynchronouslyInterruptedException exception) {
		System.out.println("");

	}

	@Override
	public void run(AsynchronouslyInterruptedException exception) throws AsynchronouslyInterruptedException {
		// TODO Auto-generated method stub

	}

}
