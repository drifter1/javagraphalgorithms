import java.util.List;
import java.util.ArrayList;

public class TestGraphs {
	
	public static List<Integer> solution;
	public static int bestTravelCost;
	
	public static void main(String[] args) {
		Graph g = new Graph(5);
		
		// add Edges
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 2);
		g.addEdge(0, 3, 3);
		g.addEdge(0, 4, 4);
		g.addEdge(1, 2, 3);
		g.addEdge(1, 3, 2);
		g.addEdge(1, 4, 2);
		g.addEdge(2, 3, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(3, 4, 1);
		
		// print Graph
		g.printGraph();
		
		// Naive Algorithm for TSP
		TSPNaive(g);
	}
	
	public static void TSPNaive(Graph g){
		int v = g.getvCount();
		
		solution = new ArrayList<Integer>();
		List<Integer> permutation = new ArrayList<Integer>();
		for (int i = 0; i < v; i++){
			solution.add(i);
			permutation.add(i);
		}
		solution.add(0);
		permutation.add(0);
		
		int travelCost = calcTravelCost(g, permutation);
		bestTravelCost = travelCost;
		
		permute(g, permutation, 1, v-1);
		
		System.out.println("\nSolution: " + bestTravelCost);
		for (int i = 0; i < solution.size(); i++){
			System.out.print(solution.get(i) + " ");
		}
		System.out.println();
	}
	
	public static int calcTravelCost(Graph g, List<Integer> permutation){
		int[][] adj = g.getAdj();
		int v = g.getvCount();
		int travelCost = 0;
		
		for(int i = 0; i < v; i++){
			int startIndex = permutation.get(i);
			int endIndex = permutation.get(i + 1);
			travelCost += adj[startIndex][endIndex];
		}
		
		return travelCost;
	}
	
	public static void swapVertices(List<Integer> permutation, int indexA, int indexB){	
		int valueA = permutation.get(indexA);
		int valueB = permutation.get(indexB);
		
		permutation.set(indexA, valueB);
		permutation.set(indexB, valueA);
	}
	
	public static void permute(Graph g, List<Integer> permutation, int l, int r){
		if (l == r){
			int travelCost = calcTravelCost(g, permutation);
			
			System.out.println("\nPermutation: " + travelCost);
			for (int i = 0; i < permutation.size(); i++){
				System.out.print(permutation.get(i) + " ");
			}
			System.out.println();			
			
			if (travelCost < bestTravelCost){
				bestTravelCost = travelCost;
				for (int i = 0; i < solution.size(); i++){
					solution.set(i, permutation.get(i));
				}
			}
		}
		else{
			for (int i = l; i <= r; i++){
				swapVertices(permutation, l, i);
				permute(g, permutation, l+1, r);
				swapVertices(permutation, l, i);
			}
		}
	}

}