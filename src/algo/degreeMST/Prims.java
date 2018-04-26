package algo.degreeMST;

import java.util.ArrayList;

import algo.degreeMST.data.Edge;
import algo.degreeMST.data.Graph;
import algo.degreeMST.data.PriorityEdgeQueue;

public class Prims {
	/**
	 * Return Minimum Spanning Tree of a graph using Prims.
	 * @param g
	 * @return
	 */
	public static ArrayList<Edge> mst(Graph g){
		
		// Initial check for graph. Must be filled!
		if ( g.isEmpty() ) {
			throw new NullPointerException("The Graph is empty");
		}
		
		// Resultant MST
		ArrayList<Edge> result = new ArrayList<Edge>();
		
		// Create adjacency graph based on original graphs edges
		ArrayList<ArrayList<Edge>> adj = generateEdgeAdjacencyGraph(g);
		
		// Initialize edge queue with the first row of adjacency edges.
		PriorityEdgeQueue peq = new PriorityEdgeQueue();
		for (int i = 0; i < adj.get(0).size(); i++) {
			Edge e = adj.get(0).get(i);
			peq.add(e);
		}
		
		// Mark first vertex as visited.
		boolean[] visited = new boolean[g.E];
		visited[0] = true;
		
		// While the Priority Edge Queue still contains edges, then MST is not complete.
		while(!peq.isEmpty()){
			
			// Return and remove closest edge in priority edge queue.
			Edge e = peq.poll();
			
			// If either vertex in this edge has been visited, continue.
			if(visited[e.src] && visited[e.dest])
				continue;
			
			// Mark this edges source vertex as visited.
			visited[e.src] = true;  
			
			// Look through every edge that shares the popped edges dest vertex
			for(Edge edge:adj.get(e.dest)){
				
				// If the edge vertex of the newly checked edge has also never been visited... 
				if(!visited[edge.dest]){
					
					// Add it to the queue!
					peq.add(edge);  
				}
			}
			
			// Mark this edges destination vertex as visited.
			visited[e.dest] = true; 
			
			// Add this edge to MST.
			result.add(e);
		}
		return result;
	}
	
	/**
	 * Take a one dimensional list of edges, and return a new two dimensional list.
	 * <br>
	 * Every index in this new list relates to a vertex in the original graph.
	 * <br>
	 * Every element in the list contains an array of all edges whos parent vertex is the same as the index.
	 * <br>
	 * <br>
	 * <b>Example:</b><br>
	 * Initial Data:<br>
		Graph g = new Graph(V, E);<br>
		g.edge[0] = new Edge(0,1,10);<br>
		g.edge[1] = new Edge(0,2,6);<br>
		g.edge[2] = new Edge(0,3,5);<br>
		g.edge[3] = new Edge(1,3,15);<br>
		g.edge[4] = new Edge(2,3,4);<br>
	 * <br>
	 * Output Data:<br>
		Vertex 0: [0, 3 : 5] [0, 2 : 6] [0, 1 : 10] <br>
		Vertex 1: [1, 0 : 10] [1, 3 : 15] <br>
		Vertex 2: [2, 3 : 4] [2, 0 : 6] <br>
		Vertex 3: [3, 2 : 4] [3, 0 : 5] [3, 1 : 15] <br> 
		Vertex 4: <br>
	 * @param g
	 * @return
	 */
	private static ArrayList<ArrayList<Edge>> generateEdgeAdjacencyGraph(Graph g) {
		ArrayList<ArrayList<Edge>> G = new ArrayList<>();
		for(int i=0;i<g.E;i++){
			G.add(new ArrayList<>());
		}
		for (int i = 0; i < g.E; i++) {
			Edge edge = g.edge[i];
			Edge reverse = new Edge(edge.dest, edge.src, edge.weight);
			
			G.get(edge.src).add(edge);
			G.get(edge.dest).add(reverse);
		}
		
		return G;
	}
}