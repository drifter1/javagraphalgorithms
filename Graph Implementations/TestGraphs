
public class TestGraphs {

	public static void main(String[] args) {
		GraphMatrix g1 = new GraphMatrix(5);
		
		System.out.println("Adjacency Matrix:");
		
		// add Edges
		g1.addEdge(0, 1);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		
		// check for existance of (1, 2)
		System.out.println("Graph has Edge (1,2) ? " + g1.hasEdge(1, 2));
		
		// remove Edge (1, 4)
		g1.removeEdge(1, 4);
		
		// print Graph
		g1.printGraph();
		
		GraphList g2 = new GraphList(5);
		
		System.out.println("\nAdjacency List:");
		
		// add Edges
		g2.addEdge(0, 1);
		g2.addEdge(1, 3);
		g2.addEdge(1, 4);
		g2.addEdge(2, 3);
		g2.addEdge(3, 4);
		
		// check for existance of (1, 2)
		System.out.println("Graph has Edge (1,2) ? " + g2.hasEdge(1, 2));
		
		// remove Edge (1, 4)
		g2.removeEdge(1, 4);
		
		// print Graph
		g2.printGraph();
		
	}

}
