public class Splay<T extends Comparable<T>> {

	private static class Node {
		public T data;
		public Node left;
		public Node right;
		public Node(T data) {this(data, null, null);}
		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	 


	public static void main(String[] args) throws Exception {
		Splay sp = new Splay();	
	}
}