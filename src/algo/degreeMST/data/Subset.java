package algo.degreeMST.data;

public class Subset {
	public int parent;
	public int rank;
	
	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}
};