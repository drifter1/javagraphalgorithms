package boruvka_mst;

import java.util.ArrayList;
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

		// Boruvka Algorithm
		System.out.println("\nBoruvka MST:");
		Graph mst = Boruvka(g);
		mst.printGraph();
	}

	public static Graph Boruvka(Graph g) {
		int v = g.getvCount();

		// initialize mst
		Graph mst = new Graph(v);

		// loop until everything is connected
		while (!mst.isConnected()) {
	
			// loop through all vertices
			for (int i = 0; i < v; i++) {
				
				// check if all nodes are reachable
				if (mst.CountReachableNodes(i) < v) {
					
					// iterate through all the edges of the current node
					Iterator<Edge> it = g.neighbours(i).iterator();
					while(it.hasNext()){
						Edge e = it.next();
						
						// add edge to mst if not added already
						// AND
						// endPoint is not reachable from elsewhere (no cycles allowed!)
						if(!mst.hasEdge(e) && !mst.Reachable(i, e.getEndPoint())){
							mst.addEdge(e);
							break;
						}
					}
				}
			}
		}

		return mst;
	}

}
