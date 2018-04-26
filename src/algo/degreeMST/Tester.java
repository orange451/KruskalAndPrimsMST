package algo.degreeMST;

import java.util.ArrayList;

import algo.degreeMST.data.Edge;
import algo.degreeMST.data.Graph;

public class Tester {
	public static void main (String[] args) {

		/* 
		  Graph used for both Kruskals and Prims!
		  
                10
            0-------1
            | \     |
           6|  5\   |15
            |     \ |
            2-------3
                4    
		*/

		int V = 4; // Number of vertices
		int E = 5; // Number of edges

		// Create graph from graphic above.
		Graph g = new Graph(V, E);
		g.edge[0] = new Edge(0,1,10);
		g.edge[1] = new Edge(0,2,6);
		g.edge[2] = new Edge(0,3,5);
		g.edge[3] = new Edge(1,3,15);
		g.edge[4] = new Edge(2,3,4);
		
		

		/**
		 * TEST 1. KRUSKAL
		 */
		
		// Generate MST using Kruskals
		ArrayList<Edge> mstKruskal = Kruskal.mst(g);
		
		// Display Kruskal MST
		System.out.println("Kruskal MST output:\n");
		displayMST(mstKruskal);
		

		
		/**
		 * TEST 2. PRIMS
		 */

		// Generate MST using Prims
		ArrayList<Edge> mstPrims = Prims.mst(g);
		
		// Display Prims MST
		System.out.println("Prims MST output:\n");
		displayMST(mstPrims);
	}

	/**
	 * Displays an arraylist of edges from a MST.
	 * @param result
	 */
	private static void displayMST(ArrayList<Edge> result) {
		int totalWeight = 0;
		for (int i = 0; i < result.size(); ++i) {
			Edge r = result.get(i);
			totalWeight += r.weight;
			System.out.println("From:   " + r.src + " to " + r.dest + "   -->   Weight: "+ r.weight);
		}
		System.out.println();
		System.out.println("\tNumber of Vertices: " + result.size());
		System.out.println("\tTotal weight: " + totalWeight);
		System.out.println("----------------");
		System.out.println();
	}

}
