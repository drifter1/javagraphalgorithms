package coloring;

import java.util.Arrays;
import java.util.Iterator;

public class TestGraph {

	public static void main(String[] args) {
		// Greedy Coloring
		System.out.println("--GREEDY ALGORITHM--");
		Graph g1 = new Graph(5);

		System.out.println("Graph:");
		// add Edges
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		// print Graph
		g1.printGraph();

		greedyColoring(g1);
		
		System.out.println("-----------------------------");

		// Backtracking Coloring
		System.out.println("--BACKTRACKING ALGORITHM--");
		Graph g2 = new Graph(5);

		System.out.println("Graph:");
		// add Edges
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 3);
		g2.addEdge(2, 3);
		g2.addEdge(3, 4);
		// print Graph
		g2.printGraph();

		backTrackingColoring(g2, 3);
	}
	
	// Greedy Coloring Function
	public static void greedyColoring(Graph g) {
		int V = g.getvCount();

		// color array
		int colors[] = new int[V];

		// initialize all vertices to '1', which means unassigned
		Arrays.fill(colors, -1);

		// assign first color (0) to first vertex
		colors[0] = 0;

		// boolean array that shows us which colors
		// are still available
		boolean available[] = new boolean[V];

		// starting off, all colors are available
		Arrays.fill(available, true);

		// assign colors to the remaining V-1 vertices
		for (int u = 1; u < V; u++) {
			// process adjacent vertices and flag
			// their colors as unavailable
			Iterator<Integer> it = g.neighbours(u).iterator();
			while (it.hasNext()) {
				int i = it.next();
				if (colors[i] != -1) {
					available[colors[i]] = false;
				}
			}

			// find the first avaiable color
			int cr;
			for (cr = 0; cr < V; cr++) {
				if (available[cr])
					break;
			}

			// assign the first avaiable color
			colors[u] = cr;

			// reset values back to true for the next iteration
			Arrays.fill(available, true);
		}

		printColors(colors);
	}

	
	// Backtracking Coloring Utility Functions
	public static boolean isSafe(int v, Graph g, int colors[], int cr) {
		for (int i = 0; i < g.getvCount(); i++) {
			if (g.hasEdge(v, i) && cr == colors[i]) {
				return false;
			}
		}
		return true;

	}

	public static boolean graphColoringUtil(Graph g, int m, int colors[], int v) {
		// all vertices have a color then just true
		if (v == g.getvCount())
			return true;

		// try different colors for v
		for (int cr = 1; cr <= m; cr++) {
			// Check if assignment of color cr to v is fine
			if (isSafe(v, g, colors, cr)) {
				colors[v] = cr;
				// recur to assign colors to rest of the vertices
				if (graphColoringUtil(g, m, colors, v + 1))
					return true;

				// If assigning color cr doesn't lead
				// to a solution then remove
				colors[v] = 0;
			}
		}

		// if no color can be assigned then return false
		return false;
	}

	// Main Backtracking Coloring Function
	public static void backTrackingColoring(Graph g, int m) {
		int V = g.getvCount();

		// color array
		int colors[] = new int[V];

		// initialize all color values to 0
		Arrays.fill(colors, 0);

		// call graphColoringUtil for vertex 0
		if (!graphColoringUtil(g, m, colors, 0)) {
			System.out.println("Solution does not exist");
		}

		printColors(colors);
	}

	// Print Colors Function
	public static void printColors(int[] colors) {
		for (int i = 0; i < colors.length; i++)
			System.out.println("Vertex " + i + " --->  Color " + colors[i]);
	}
}
