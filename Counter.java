import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	private final Lock lock = new ReentrantLock();
	private int value = 0;

	public int increment() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}

	public int get() {
		try {
			lock.lock();
			return value;
		} finally {
			lock.unlock();
		}
	}
}