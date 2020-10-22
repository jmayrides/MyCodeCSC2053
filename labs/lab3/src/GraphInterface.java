import java.util.Queue;

public interface GraphInterface<T> {
	/**
	 * Returns true if this graph is empty; otherwise, returns false.
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * Returns true if this graph is full; otherwise, returns false.
	 * @return
	 */
	boolean isFull();
	
	/**
	 * Preconditions:   This graph is not full.
	                    vertex is not already in this graph.
	                    vertex is not null.
	
	 * Adds vertex to this graph.
	 * @param vertex
	 */
	void addVertex(T vertex);
	
	/**
	 * Returns true if this graph contains vertex; otherwise, returns false.
	 * @param vertex
	 * @return
	 */
	boolean hasVertex(T vertex); 
	
	/**
	 * Adds an edge between vertex1 and vertex2.
	 * Because this graph is undirected, it also adds an edge in both directions
	 * @param vertex1
	 * @param vertex2
	 */
	void addEdge(T vertex1, T vertex2); 

	/**
	 * Returns a queue of the vertices that vertex is adjacent to.
	 * @param vertex
	 * @return
	 */
	Queue<T> getToVertices(T vertex);

	/**
	 * Unmarks all vertices.
	 */
	void clearMarks(); 

	/**
	 * Marks vertex.
	 * @param vertex
	 */
	void markVertex(T vertex);

	/**
	 * Returns true if vertex is marked; otherwise, returns false.
	 * @param vertex
	 * @return
	 */
	boolean isMarked(T vertex);


	/**
	 * Returns an unmarked vertex if any exist; otherwise, returns null.
	 * @return
	 */
	T getUnmarked(); 
}
