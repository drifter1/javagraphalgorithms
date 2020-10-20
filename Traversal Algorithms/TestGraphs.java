package traversal;

import java.util.LinkedList;
import java.util.Stack;

public class TestGraphs {

	public static void main(String[] args) {
		Graph g = new Graph(5);

		System.out.println("Graph:");
		// add Edges
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 2);

		// print Graph
		g.printGraph();

		// Traversal Algorithms
		System.out.println("BFS:");
		bfs(g, 0);
		bfs(g, 1);

		System.out.println("DFS:");
		dfs(g, 0);
		dfs(g, 1);
	}

	public static void bfs(Graph g, int v) {
		boolean[] seen = new boolean[g.getvCount()];
		LinkedList<Integer> q = new LinkedList<Integer>(); // queue-like
		q.add(v);
		seen[v] = true;
		while (!q.isEmpty()) {
			int i = q.remove();
			for (Integer j : g.neighbours(i)) {
				if (!seen[j]) {
					q.add(j);
					seen[j] = true;
				}
			}
		}
		System.out.print(v + " -> ");
		for (int i = 0; i < seen.length; i++) {
			if (seen[i])
				System.out.print(i + ", ");
		}
		System.out.println();

	}

	public static void dfs(Graph g, int v) {
		byte white = 0, grey = 1, black = 2;
		byte[] c = new byte[g.getvCount()];
		Stack<Integer> s = new Stack<Integer>();
		s.push(v);
		while (!s.isEmpty()) {
			int i = s.pop();
			if (c[i] == white) {
				c[i] = grey;
				for (int j : g.neighbours(i))
					s.push(j);
				c[i] = black;
			}
		}
		System.out.print(v + " -> ");
		for (int i = 0; i < c.length; i++) {
			if (c[i] == black)
				System.out.print(i + ", ");
		}
		System.out.println();

	}

}
