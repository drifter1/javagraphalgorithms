package dijkstra;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestGraphs {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		
		System.out.println("Graph:");
		// add Edges
		g.addEdge(0, 1, 5.2f);
		g.addEdge(0, 3, 12.8f);
		g.addEdge(0, 2, 10.3f);
		g.addEdge(1, 3, 5.9f);
		g.addEdge(1, 4, 15.2f);
		g.addEdge(2, 1, 1.5f);
		g.addEdge(2, 3, 2.3f);
		g.addEdge(3, 4, 8.5f);
		g.addEdge(4, 2, 2.7f);
		
		// print Graph
		g.printGraph();

		// Dijkstra Shortest Path Algorithm
		System.out.println("Dijkstra Shortest Path:");
		Dijkstra(g, 0);
	}

	public static void Dijkstra(Graph g, int startVertex) {
		// for storing distances after removing vertex from Queue
		float[] distances = new float[g.getvCount()];
		// for storing father id's after removing vertex from Queue
		int[] parents = new int[g.getvCount()];
		for (int i = 0; i < g.getvCount(); i++) {
			parents[i] = -1;
		}

		// set up vertex queue
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		for (int i = 0; i < g.getvCount(); i++) {
			if (i != startVertex) {
				Q.add(new Vertex(i));
			}
		}

		// add startVertex
		Vertex node = new Vertex(startVertex);
		node.setDistance(0);
		Q.add(node);

		// loop through all vertices
		while (!Q.isEmpty()) {
			// get vertex with shortest distance
			Vertex u = Q.remove();
			distances[u.getId()] = u.getDistance();

			// iterate through all neighbours
			Iterator<Edge> it = g.neighbours(u.getId()).iterator();
			while (it.hasNext()) {
				Edge e = it.next();
				Iterator<Vertex> it2 = Q.iterator();
				while (it2.hasNext()) {
					Vertex v = it2.next();
					// check if vertex was visited already
					if (e.getEndPoint() != v.getId()) {
						continue;
					}
					// check distance 
					if (v.getDistance() > u.getDistance() + e.getWeight()) {
						v.setDistance(u.getDistance() + e.getWeight());
						v.setParent(u);
						parents[v.getId()] = v.getParent().getId();
					}
				}
			}

		}
		
		// print final shortest paths
		System.out.println("Vertex\tDistance\tParent Vertex");
		for (int i = 0; i < g.getvCount(); i++) {
			System.out.println(i + "\t" + distances[i] + "\t\t" + parents[i]);
		}

	}
}
