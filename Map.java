public class Map<Key, Value> {

	private class Node {
		private Object key;
		private Object value;
		private Node next;

		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node[] chains = new Node[8];
	private int total = 8;
	private int count = 0;

	public Map(int capacity) {
		
	}

	public void resize(int chainc) {
		Map<Key, Value> temp = new Map<Key, Value>(chainc);
		for (int i = 0; i < total; i++)
			for (Node r = chains[i]; r != null; r = r.next)
				temp.put((Key) r.key, (Value) r.value);
		this.count = temp.count;
		this.total = temp.total;
		this.chains = temp.chains;
	}

	public void put(Key key, Value value) {
		if (count >= 10*capacity) resize(2*capacity);
		int i = hash(key);
		chains[i] = new Node(key, value, chains[i]);
		count++;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		int i = hash(key);
		for (Node r = chains[i]; r != null; r = r.next) {
			if (key.equals(r.key))
				return (Value) r.value;
		}
		return null;
	}

	public int hash(Key key) {
		return key.hashCode() % capacity;
	}

	public boolean empty() {return count == 0;}
	public int size() {return count;}

	public static void main(String... args) {
		Map<Character, String> m = new Map<Character, String>();
		m.put('A', "Atman");
		m.put('D', "Deepu");
		m.put('A', "Arjun");
		m.put('B', "Brahman");
		System.out.println(m.size()+m.get('A')+m.get('A'));
	}
}