package euleriancircuits;

import java.util.Iterator;

public class TestGraph {

	public static void main(String[] args) {
		/* Eulerian Path Example */
		Graph g = new Graph(5);

		System.out.println("Graph:");
		// add Edges
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 4);

		// print Graph
		g.printGraph();

		// Eulerian Circuit Algorithm
		eulerianCircuit(g);
		
		/* Eulerian Cycle Example */
		Graph g1 = new Graph(5);

		System.out.println("\nGraph:");
		// add Edges
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(1, 2);
		g1.addEdge(3, 4);
		g1.addEdge(4, 0); // I simply added one Edge

		// print Graph
		g1.printGraph();

		// Eulerian Circuit Algorithm
		eulerianCircuit(g1);
	}
	
	// test function the main one is isEulerian()
	static void eulerianCircuit(Graph g) {
		int result = isEulerian(g);
		if (result == 0)
			System.out.println("Graph is not Eulerian");
		else if (result == 1)
			System.out.println("Graph contains a Euler path");
		else // 2
			System.out.println("Graph contains a Euler cycle");
	}

	// returns 0: not eulerian, 1: euler path, 2: euler cycle
	static int isEulerian(Graph g) {
		// Check if all non-zero degree vertices are connected
		if (isConnected(g) == false)
			return 0;

		// Count vertices with odd degree
		int odd = 0;
		for (int i = 0; i < g.getvCount(); i++)
			// check number of neighbours or degree
			if (g.neighbours(i).size() % 2 != 0)
				odd++;

		// Check number of odd vertices
		if (odd > 2) { // non-eulerian
			return 0;
		} else if (odd == 2) { // semi-eulerian
			return 1;
		} else { // eulerian
			return 2;
		}
	}

	static boolean isConnected(Graph g) {
		// array to store if vertices where visited
		boolean visited[] = new boolean[g.getvCount()];
		
		// initialze all to non-visited
		int i;
		for (i = 0; i < g.getvCount(); i++) {
			visited[i] = false;
		}
		
		// Find vertex with non-zero degree
		for (i = 0; i < g.getvCount(); i++) {
			if (g.neighbours(i).size() != 0)
				break;
		}
		
		// If there are no edges in the graph (special case) then return true
		if (i == g.getvCount())
			return true;

		// DFS Traversal starting from non-zero vertex
		DFS(g, i, visited);

		// Check if all non-zero degree vertices are visited
		for (i = 0; i < g.getvCount(); i++)
			if (visited[i] == false && g.neighbours(i).size() > 0)
				return false;
		// if at least one was not visited false, else we return true
		return true;
	}
	
	static void DFS(Graph g, int sourceVertex, boolean visited[]){
		// Mark source node as visited
        visited[sourceVertex] = true;
 
        // recursion for all the vertices adjacent to this one
        Iterator<Integer> it = g.neighbours(sourceVertex).iterator();
        while (it.hasNext())
        {
            int nextVertex = it.next();
            if (!visited[nextVertex])
                DFS(g, nextVertex, visited);
        }
	}
}
