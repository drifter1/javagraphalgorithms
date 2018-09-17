import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphList {
	private int vCount;
	private List<Integer>[] adj;

	public GraphList(int vCount) {
		this.vCount = vCount;
		adj = (List<Integer>[]) new List[vCount];
		for (int i = 0; i < vCount; i++)
			adj[i] = new ArrayList<Integer>();
	}

	public void addEdge(int i, int j) {
		adj[i].add(j);
		adj[j].add(i);
	}

	public void removeEdge(int i, int j) {
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				break;
			}
		}
		Iterator<Integer> it2 = adj[j].iterator();
		while (it2.hasNext()) {
			if (it2.next() == i) {
				it2.remove();
				return;
			}
		}
	}

	public boolean hasEdge(int i, int j) {
		return adj[i].contains(j);
	}

	public List<Integer> neighbours(int vertex) {
		return adj[vertex];
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
