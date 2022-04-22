public class Queue4<T> {

	private Stack<T> st;

	public Queue4() {
		this.st = new Stack<T>();
	}

	public void enqueue(T elem) {
		st.push(elem);
	}

	public T dequeue() {
		if (st.empty()) throw new Error("queue underflow");
		int val = st.pop();
		if (st.empty()) return val;
		else {
			T elem = dequeue();
			st.push(val);
			return elem;
		}
	}

	public boolean empty() {
		return s1.empty() && s2.empty();
	}
}