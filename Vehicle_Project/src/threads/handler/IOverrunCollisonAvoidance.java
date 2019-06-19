package threads.handler;

import java.util.logging.Logger;

import javax.realtime.RealtimeThread;

public interface IOverrunCollisonAvoidance {

	public void setLogger(Logger logger);

	public void setThread(RealtimeThread realtimeThread);
}
