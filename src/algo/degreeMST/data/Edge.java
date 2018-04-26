package algo.degreeMST.data;
public class Edge implements Comparable<Edge> {
	public int src;
	public int dest;
	public int weight;
	
	public Edge( int source, int dest, int weight ) {
		this.src = source;
		this.dest = dest;
		this.weight = weight;
	}
	
	public int compareTo(Edge compareEdge) {
		return this.weight-compareEdge.weight;
	}

};