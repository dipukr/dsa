import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyMatrix {
	
	private boolean[][] matrix;
	private int size;

	public AdjacencyMatrix(int size) {
		this.size = size;
		this.matrix = new boolean[size][size];
	}

	public void addEdge(int from, int to) {
		matrix[from][to] = true;
		matrix[to][from] = true;
	}

	public void removeEdge(int from, int to) {
		matrix[from][to] = false;
		matrix[to][from] = false;
	}

	public void bfs(int start) {
		boolean[] marked = new boolean[size];
		for (int i = 0; i < size; ++i)
			marked[i] = false;
		var queue = new Queue<Integer>();
		marked[start] = true;
		queue.offer(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			visit(u);
			for (int i = 0; i < size; ++i)
				if (matrix[u][i] && !marked[i]) {
					queue.offer(i);
					marked[i] = true;
				}
		}
	}

	public void visit(int node) {System.out.print(node+"\t");}
	public int size() {return size;}

	public static void main(String[] args) throws Exception {
		AdjcencyMatrix g = new AdjcencyMatrix(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(4, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(4, 1);
		g.bfs(3);
	}
}