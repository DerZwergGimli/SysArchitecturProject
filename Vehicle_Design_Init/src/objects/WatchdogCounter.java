package objects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WatchdogCounter {

	private final Lock queueLock = new ReentrantLock();
	private int counter = -1;

	public WatchdogCounter(int counter) {
		this.counter = counter;

	}

	public void countUP() {
		queueLock.lock();
		try {
			this.counter++;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
			System.out.println("CounterUP=" + this.counter);
		}
	}

	public void countDOWN() {
		queueLock.lock();
		try {
			this.counter = 100;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
			System.out.println("CounterDOWN=" + this.counter);
		}
	}

	public int getCounter() {
		return counter;
	}

}
