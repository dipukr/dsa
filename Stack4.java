public class Stack4<T> {

	private Queue<T> q1;
	private Queue<T> q2;
	private int count;

	public Stack4() {
		this.q1 = new Queue<T>();
		this.q2 = new Queue<T>();
		this.count = 0;
	}

	public void push(T elem) {
		q1.enqueue(elem);
		count++;
		while (!q1.empty())
			q2.enqueue(q1.dequeue())
		Queue<T> temp = q1;
		q1 = q2;
		q2 = q1;
	}

	public T pop() {
		count--;
		return q1.dequeue();
	}

	public T top() {
		return q1.front();
	}

	public int size() {
		return count;
	}
}