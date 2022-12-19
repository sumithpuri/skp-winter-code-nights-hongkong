// tested by code@sumithpuri.xyz on [19/Dec/2022]
// please star/like, follow & fork from my github

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Feel free to distribute, modify or include
 */

/**
 * @author sumithpuri
 * @label jdk7certify
 * 
 *        An Implementation of the Djikstra's Algorithm (Object-Oriented Programming).
 *
 */
class Vertex implements Comparable<Vertex> {

	private String name;
	private Edge[] adjacency;

	// public variable - not a good oop practice
	public Double distance = Double.POSITIVE_INFINITY;
	private Vertex previous = null;

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAdjacencyList(Edge[] adjacency) {
		this.adjacency = adjacency;
	}

	@Override
	public int compareTo(Vertex cVertex) {
		return Double.compare(this.distance, cVertex.distance);
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public Edge[] getAdjacencyList() {

		return adjacency;
	}
}

class Edge {

	private int weight;
	private Vertex target;

	public Edge(int weight, Vertex target) {
		this.target = target;
		this.weight = weight;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the target
	 */
	public Vertex getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(Vertex target) {
		this.target = target;
	}

}

public class Dijkstra {

	// dijkstra's main algorithm - single source shortest path to all vertices
	public void singleSourcePaths(Vertex vertex) {

		vertex.distance = 0d;
		PriorityQueue<Vertex> pQ = new PriorityQueue<Vertex>();
		pQ.add(vertex);

		while (!pQ.isEmpty()) {
			Vertex u = pQ.poll();
			Edge[] adjacencyList = u.getAdjacencyList();

			for (Edge edge : adjacencyList) {

				Vertex v = edge.getTarget();

				double totalDistance = u.distance + edge.getWeight();
				if (totalDistance < v.distance) {
					pQ.remove(u);
					v.distance = totalDistance;
					v.setPrevious(u);
					pQ.add(v);
				}
			}
		}
	}

	public List<Vertex> getShortestPathTo(Vertex target) {

		List<Vertex> vertices = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious())
			vertices.add(vertex);

		Collections.reverse(vertices);
		return vertices;
	}

	public static void main(String[] args) {

		Vertex v0 = new Vertex("mumbai");
		Vertex v1 = new Vertex("bengaluru");
		Vertex v2 = new Vertex("delhi");
		Vertex v3 = new Vertex("kochi");
		Vertex v4 = new Vertex("pune");
		Vertex v5 = new Vertex("gurgaon");

		v0.setAdjacencyList(
				new Edge[] { new Edge(14, v1), new Edge(20, v2), new Edge(14, v3), new Edge(2, v4), new Edge(19, v5) });
		v1.setAdjacencyList(new Edge[] { new Edge(14, v0), new Edge(12, v1), new Edge(12, v4), new Edge(21, v5) });
		v2.setAdjacencyList(new Edge[] { new Edge(20, v2), new Edge(1, v5) });
		v3.setAdjacencyList(new Edge[] { new Edge(16, v0), new Edge(12, v1), new Edge(14, v4) });
		v4.setAdjacencyList(new Edge[] { new Edge(2, v0), new Edge(12, v1), new Edge(14, v3) });
		v5.setAdjacencyList(new Edge[] { new Edge(19, v0), new Edge(21, v1), new Edge(1, v2) });

		Vertex vertices[] = new Vertex[] { v0, v1, v2, v3, v4, v5 };

		// run djikstra's to compute single-source shortest path
		// example - from kochi to all cities

		Vertex source = v3;
		Dijkstra dijkstra = new Dijkstra();
		dijkstra.singleSourcePaths(source);

		for (Vertex vertex : vertices) {
			System.out.println("the total distance from " + source.getName() + " to " + vertex.getName() + " is "
					+ vertex.distance);
			List<Vertex> vertexList = dijkstra.getShortestPathTo(vertex);
			System.out.print("the shortest path from " + source.getName() + " to " + vertex.getName() + " is");
			for (Vertex v : vertexList) {
				System.out.print(" > ");
				System.out.print(v.getName());
			}
			System.out.println();
		}

	}

}
