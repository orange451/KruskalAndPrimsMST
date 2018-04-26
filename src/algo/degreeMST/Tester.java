package algo.degreeMST;

import java.util.ArrayList;

import algo.degreeMST.data.Edge;
import algo.degreeMST.data.Graph;

public class Tester {
	public static void main (String[] args) {

		/* 
		  Graph used for both Kruskals and Prims tests.
		  
                9
            0-------1
            | \     |
           8|  6\   |12
            |     \ |
            2-------3
                5    
                
		*/

		int V = 4; // Number of vertices (0,1,2,3)
		int E = 5; // Number of edges ( 0:1 -> 9,  0:2 -> 8,  0:3 -> 6,  1:3 -> 12,  2:3 -> 5 )

		// Create graph from graphic above.
		Graph g = new Graph(V, E);
		g.edge[0] = new Edge(0,1,9);
		g.edge[1] = new Edge(0,2,8);
		g.edge[2] = new Edge(0,3,6);
		g.edge[3] = new Edge(1,3,12);
		g.edge[4] = new Edge(2,3,5);
		
		

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
