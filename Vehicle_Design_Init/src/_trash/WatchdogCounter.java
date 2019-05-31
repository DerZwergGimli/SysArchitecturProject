package _trash;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WatchdogCounter {

	private final Lock queueLock = new ReentrantLock();
	private int counter = -1;

	public WatchdogCounter(int counter) {
		this.counter = counter;

	}

	public void countDown() {
		queueLock.lock();
		try {
			this.counter--;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
			System.out.println("Counter_down=" + this.counter);
		}
	}

	public void countReset() {
		queueLock.lock();
		try {
			this.counter = 100;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			queueLock.unlock();
			System.out.println("Counter_reset=" + this.counter);
		}
	}

	public int getCounter() {
		return counter;
	}

}
