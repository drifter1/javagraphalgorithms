import java.util.List;
import java.util.ArrayList;

public class GraphMatrix {
	private int vCount;
	private boolean[][] adj;

	public GraphMatrix(int vCount) {
		this.vCount = vCount;
		adj = new boolean[vCount][vCount];
	}

	public void addEdge(int i, int j) {
		adj[i][j] = adj[j][i] = true;
	}

	public void removeEdge(int i, int j) {
		adj[i][j] = adj[j][i] = false;
	}

	public boolean hasEdge(int i, int j) {
		return adj[i][j];
	}

	public List<Integer> neighbours(int vertex) {
		List<Integer> edges = new ArrayList<Integer>();
		for (int i = 0; i < vCount; i++)
			if (adj[vertex][i])
				edges.add(i);
		return edges;
	}

	public void printGraph() {
		for (int i = 0; i < vCount; i++) {
			List<Integer> edges = neighbours(i);
			System.out.print(i + ": ");
			for (int j = 0; j < edges.size(); j++) {
				System.out.print(edges.get(j) + " ");
			}
			System.out.println();
		}
	}
}
