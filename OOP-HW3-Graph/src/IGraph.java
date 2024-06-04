import java.util.List;


public interface IGraph<V extends Comparable<V>> {

	/**
	 * Add a new vertex if none exists.
	 */
	public void addVertex(V v);

	/**
	 * Add a new edge if none exists between the two vertices. If the vertices u or
	 * v do not exist, add them to the graph.
	 */
	public void addEdge(V u, V v);

	/**
	 * @return If the graph contains the vertex v.
	 */
	public boolean containsVertex(V v);

	/**
	 * @param u, v
	 * @return If the the edge (u,v) exists.
	 */
	public boolean containsEdge(V u, V v);

	/**
	 * Remove the vertex and its edges from the graph, and return its incidents. If
	 * the vertex dosn't exit return null.
	 */
	public List<V> removeVertex(V v);

	/**
	 * @return Remove the edge (u,v) if it exists, and return True. If this edge
	 *         does not exist return False.
	 */
	public boolean removeEdge(V u, V v);
	
	
	/**
	 * @return the type of the graph "Directed" or "Undirected".
	 */
	public String getGraphType();

	/**
	 * @return the number of vertices
	 */
	public int numOfVertices();
	
	/**
	 * @return the number of edges
	 */	
	public int numOfEdges();

	/**
	 * Generates a concise string representation of the graph.
	 * The format differs for directed and undirected graphs:
	 * 
	 * Directed graphs:
	 * "DirectedGraph:" is followed by each vertex and its outgoing edges. Vertices are
	 * separated by spaces. Edges are denoted as "X->Y" for an edge from vertex X to vertex Y.
	 * 
	 * Undirected graphs:
	 * "UndirectedGraph:" is followed by each vertex and its incident edges. For undirected
	 * graphs, edges between vertices are represented as "X:Y", indicating an edge between
	 * vertex X and vertex Y. Multiple edges for a vertex are separated by '->'.
	 * 
	 * Example (Directed):
	 * "DirectedGraph:\tA:B B:C->D C:A D:A->D" represents a directed graph with edges
	 * from A to B, B to C and D, C to A, and D to A and D itself.
	 * 
	 * Example (Undirected):
	 * "UndirectedGraph:\tA:B B:A->C->D C:B->D D:B->C" represents an undirected graph with
	 * edges (A,B), (B,C), (B,D), (C,D). These edges show bidirectional connections
	 * between the vertices as described, with multiple edges for a vertex separated by '->'.
	 *
	 * @return A string representing the graph in the specified format.
	 */
	public String toString();


}