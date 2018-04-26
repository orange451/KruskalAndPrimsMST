package algo.degreeMST.data;

import java.util.PriorityQueue;

public class PriorityEdgeQueue {
	private PriorityQueue<Edge> queue;
	
	public PriorityEdgeQueue() {
		queue = new PriorityQueue<Edge>((Edge o1, Edge o2) -> {
			return o1.compareTo(o2);
		});
	}

	public void add(Edge e) {
		queue.add(e);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Edge peek() {
		return queue.peek();
	}

	public Edge poll() {
		return queue.poll();
	}
}
