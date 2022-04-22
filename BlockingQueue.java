public class BlockingQueue<E> {

	private ReentrantLock lock = new ReentrantLock(true);
	private Queue<E> queue;
	private int max = 16;

	public BlockingQueue(int size) {
		this.max = size;
		this.queue = new LinkedList<E>();`
	}

	public void put(E e) {
		lock.lock();
		try {
			queue.add(e);	
		} finally {
			lock.unlock();
		}
	}

	public E take() {
		lock.lock();
		try {
			E val = queue.remove();
			return item;
		} finally {
			lock.unlock();
		}
		return val;
	}
}