package mst;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestGraphs {

	public static void main(String[] args) {
		Graph g = new Graph(5);

		System.out.println("Graph:");
		// add Edges
		g.addEdge(0, 1, 5.2f);
		g.addEdge(0, 3, 7.1f);
		g.addEdge(1, 3, 5.9f);
		g.addEdge(1, 4, 3.4f);
		g.addEdge(2, 1, 1.5f);
		g.addEdge(2, 3, 2.3f);
		g.addEdge(3, 4, 8.5f);
		g.addEdge(4, 2, 2.7f);

		// print Graph
		g.printGraph();

		// MST Algorithms
		System.out.println("Kruskal MST:");
		Graph mst_1 = Kruskal(g);
		mst_1.printGraph();
		
		System.out.println("Prim MST:");
		Graph mst_2 = Prim(g, 0);
		mst_2.printGraph();
	}

	public static Graph Kruskal(Graph g) {
		Graph mst = new Graph(g.getvCount());
		boolean[] marked = new boolean[g.getvCount()];

		// create queue of all edges in ascending order
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		for (int i = 0; i < g.getvCount(); i++) {
			Iterator<Edge> it = g.neighbours(i).iterator();
			while (it.hasNext()) {
				edges.add(it.next());
			}
		}

		// first edge insert
		Edge e = edges.remove();
		mst.addEdge(e);
		marked[e.getStartPoint()] = true;

		// loop until no edges remain
		while (!edges.isEmpty()) {
			// get the edge with the less weight
			Edge temp = edges.remove();

			// if no circle is being made
			if (!marked[temp.getEndPoint()]) {
				if (!mst.hasEdge(temp)) {
					mst.addEdge(temp);
					marked[temp.getEndPoint()] = true;
				}
			}

		}
		return mst;
	}

	public static Graph Prim(Graph g, int startVertex) {
		Graph mst = new Graph(g.getvCount());
		boolean[] marked = new boolean[g.getvCount()];

		// insert neighbours of first vertex
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		Iterator<Edge> it = g.neighbours(startVertex).iterator();
		while (it.hasNext()) {
			edges.add(it.next());
		}
		marked[startVertex] = true;

		// loop until no edges remain
		while (!edges.isEmpty()) {
			Edge e = edges.remove();

			// if adding makes no circle
			if (!marked[e.getEndPoint()]) {
				mst.addEdge(e);
				marked[e.getEndPoint()] = true;

				// add neighbour edges of vertex if don't marked yet
				Iterator<Edge> i = g.neighbours(e.getEndPoint()).iterator();
				while (i.hasNext())
					edges.add(i.next());
				marked[e.getEndPoint()] = true;

			}
		}

		return mst;
	}

}
