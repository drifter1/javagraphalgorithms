package boruvka_mst;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph {
	private int vCount;
	private PriorityQueue<Edge>[] adj;

	public int getvCount() {
		return vCount;
	}

	public Graph(int vCount) {
		this.vCount = vCount;
		adj = new PriorityQueue[vCount];
		for (int i = 0; i < vCount; i++)
			adj[i] = new PriorityQueue<Edge>();
	}

	public void addEdge(int i, int j, float weight) {
		if (!hasEdge(new Edge(i, j, weight))) {
			adj[i].add(new Edge(i, j, weight));
			adj[j].add(new Edge(j, i, weight));
		}
	}

	public void addEdge(Edge e) {
		if (!hasEdge(e)) {
			adj[e.getStartPoint()].add(e);
			adj[e.getEndPoint()].add(e.opposite());
		}
	}

	public void removeEdge(int i, int j) {
		Iterator<Edge> it = adj[i].iterator();
		Edge other = new Edge(i, j, 0);
		while (it.hasNext()) {
			if (it.next().equals(other)) {
				it.remove();
				break;
			}
		}

		Iterator<Edge> it2 = adj[j].iterator();
		Edge other2 = new Edge(j, i, 0);
		while (it2.hasNext()) {
			if (it2.next().equals(other2)) {
				it2.remove();
				break;
			}
		}
	}

	public boolean hasEdge(Edge e) {
		Iterator<Edge> it = adj[e.getStartPoint()].iterator();
		while (it.hasNext()) {
			if (it.next().equals(e)) {
				return true;
			}
		}
		return false;
	}

	public PriorityQueue<Edge> neighbours(int vertex) {
		return adj[vertex];
	}

	public boolean isConnected() {
		// array to store if vertices where visited
		boolean visited[] = new boolean[vCount];

		// initialze all to non-visited
		int i;
		for (i = 0; i < vCount; i++) {
			visited[i] = false;
		}

		// check for vertex with non-zero degree
		for (i = 0; i < vCount; i++) {
			if (neighbours(i).size() == 0)
				return false; // if there is one return false
		}

		// DFS Traversal starting from non-zero vertex
		DFS(0, visited);

		// Check if all vertices have been visited
		for (i = 0; i < vCount; i++)
			if (visited[i] == false)
				return false;
		// if at least one was not visited false, else we return true
		return true;
	}

	public void DFS(int sourceVertex, boolean visited[]) {
		// Mark source node as visited
		visited[sourceVertex] = true;

		// recursion for all the vertices adjacent to this one
		Iterator<Edge> it = neighbours(sourceVertex).iterator();
		while (it.hasNext()) {
			Edge nextVertex = it.next();
			if (!visited[nextVertex.getEndPoint()])
				DFS(nextVertex.getEndPoint(), visited);
		}
	}

	public int CountReachableNodes(int sourceVertex) {
		// array to store if vertices where visited
		boolean visited[] = new boolean[vCount];

		// initialze all to non-visited
		for (int i = 0; i < vCount; i++) {
			visited[i] = false;
		}

		DFS(sourceVertex, visited);

		int count = 0;
		for (int i = 0; i < vCount; i++) {
			if(visited[i] == true)
				count++;
		}
		return count;
	}
	
	public boolean Reachable(int sourceVertex, int destVertex){
		// array to store if vertices where visited
		boolean visited[] = new boolean[vCount];

		// initialze all to non-visited
		for (int i = 0; i < vCount; i++) {
			visited[i] = false;
		}
		
		DFS(sourceVertex, visited);

		return visited[destVertex];	
	}

	public void printGraph() {
		for (int i = 0; i < vCount; i++) {
			PriorityQueue<Edge> edges = neighbours(i);
			Iterator<Edge> it = edges.iterator();
			System.out.print(i + ": ");
			for (int j = 0; j < edges.size(); j++) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}
}
