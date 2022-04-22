import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LatchCondition {

	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	private volatile boolean flag = false;

	public void waitTillChange() {
		lock.lock();
		try {
			while (flag == false)
				cond.await();
		} finally {
			lock.unlock();
		}
	}

	public void change() {
		lock.lock();
		try {
			flag = true;
			cond.signalAll();
		} finally {
			lock.unlock();
		}
	}
}