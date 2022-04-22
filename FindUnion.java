public class FindUnion {

	private int[] parent;

	public FindUnion(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;
	}

	public int root(int u) {
		if (u == parent[u])
			return u;
		return root(parent[u]);
	}

	public boolean find(int u, int v) {
		return root(u) == root(v);
	}

	public void union(int u, int v) {
		int r1 = root(u);
		int r2 = root(v);
		if (r1 != r2) parent[v] = u;
	}
}