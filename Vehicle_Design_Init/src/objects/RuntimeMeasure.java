package objects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RuntimeMeasure {

	private final Lock queueLock = new ReentrantLock();
	private long startTimeNano;
	private long endTimeNano;
	private long deltaTimeNano;

	public RuntimeMeasure() {
		// TODO Auto-generated constructor stub
	}

	public void start() {
		queueLock.lock();
		try {
			this.startTimeNano = System.nanoTime();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
		}
	}

	public void end() {
		queueLock.lock();
		try {
			this.endTimeNano = System.nanoTime();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
		}
	}

	public long timeConsumtion() {
		queueLock.lock();
		try {
			this.deltaTimeNano = this.endTimeNano - this.startTimeNano;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
		}

		return this.deltaTimeNano;
	}

}
