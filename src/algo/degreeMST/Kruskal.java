package algo.degreeMST;
import java.util.*;

import algo.degreeMST.data.Edge;
import algo.degreeMST.data.Graph;
import algo.degreeMST.data.PriorityEdgeQueue;
import algo.degreeMST.data.Subset;

import java.lang.*;

import java.io.*;

public class Kruskal {
	/**
	 * Return Minimum Spanning Tree of a graph using Kruskals.
	 * @param g
	 * @return
	 */
	public static ArrayList<Edge> mst(Graph g) {
		
		// Initial check for graph. Must be filled!
		if ( g.isEmpty() ) {
			throw new NullPointerException("The Graph is empty");
		}
		
		// Resultant MST
		ArrayList<Edge> result = new ArrayList<Edge>();

		// Sort edges based on weight (ASC order) using Priority edge queue.
		PriorityEdgeQueue peq = new PriorityEdgeQueue();
		for (int i = 0; i < g.E; i++) {
			peq.add(g.edge[i]);
		}

		// Create subsets for all vertices
		Subset subsets[] = new Subset[g.V];
		for (int v = 0; v < g.V; ++v) {
			subsets[v] = new Subset(v, 0);
		}

		// if priority edge queue is not empty, then MST is not complete.
		while (!peq.isEmpty()) {
			if ( result.size() >= g.V - 1 )
				break;

			// Get current edge
			Edge next_edge = peq.poll();

			// Find subsets based on source and dest of current edge.
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			// If subset y (dest) is not subset x (src), union them.
			if (x != y) {
				result.add(next_edge);
				Union(subsets, x, y);
			}
		}

		return result;
	}
	
	/**
	 * Returns the parent vertex of a subset. If the parent is not yet set
	 * then it will search for it using path compression.
	 * @param subsets
	 * @param i
	 * @return
	 */
	private static int find(Subset subsets[], int i) {
		if (subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}

		return subsets[i].parent;

	}

	/**
	 * Unions subset X and subset Y based on rank.
	 * @param subsets
	 * @param x
	 * @param y
	 */
	private static void Union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
}