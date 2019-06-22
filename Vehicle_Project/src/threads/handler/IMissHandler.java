package threads.handler;

import java.util.logging.Logger;

import javax.realtime.AsynchronouslyInterruptedException;
import javax.realtime.RealtimeThread;

public interface IMissHandler {

	public void setInterruptExeption(AsynchronouslyInterruptedException asInterrupExeption);

	public void setThread(RealtimeThread realtimeThread);

	public void setLogger(Logger logger);

}
