package reverse_delete;

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

		// Reverse-Delete Algorithm
		System.out.println("\nReverse-Delete MST:");
		Graph mst = Reverse_Delete(g);
		mst.printGraph();
	}

	public static Graph Reverse_Delete(Graph g) {
		int v = g.getvCount();
		int e = 0; // edge count
		Graph mst = new Graph(v);

		// create queue of all edges in descending order
		// AND
		// initialize mst to given graph
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		for (int i = 0; i < v; i++) {
			Iterator<Edge> it = g.neighbours(i).iterator();
			while (it.hasNext()) {
				Edge temp = it.next();
				if (!mst.hasEdge(temp)) {
					mst.addEdge(temp); // add edge to mst
					edges.add(temp); // add edge to queue
					e++; // increment edge count
				}
			}
		}

		// loop through all the edges
		for (int i = 0; i < e; i++) {
			// get most-weighted edge
			Edge temp = edges.remove();

			// remove the edge from the mst
			mst.removeEdge(temp.getStartPoint(), temp.getEndPoint());

			// check if it stays connected
			if (!mst.isConnected()) {
				mst.addEdge(temp); // add edge back
			}
		}

		return mst;
	}

}
