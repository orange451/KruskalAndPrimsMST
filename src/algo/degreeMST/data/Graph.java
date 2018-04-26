package algo.degreeMST.data;

public class Graph {
	public int V;
	public int E;
	public Edge[] edge;
	
	public Graph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
	}
	
	/**
	 * Returns true if the entire graph is NOT filled.
	 * @return
	 */
	public boolean isEmpty() {
		for (int i = 0; i < E; i++) {
			if ( edge[i] == null )
				return true;
		}
		
		return false;
	}
}

