/**
 * 
 * @author Jack Mayrides
 * 
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class UndirectedGraph<T> implements GraphInterface<T> {

	public static final int NULL_EDGE = 0;
	private static final int DEFCAP = 50;  // default capacity
	private int numVertices;
	private int maxVertices;
	public T[] vertices;
	public int[][] edges;
	private boolean[] marks;  // marks[i] is mark for vertices[i]

	// Instantiates a graph with capacity DEFCAP vertices.
	public UndirectedGraph() {

		numVertices = 0;
		maxVertices = DEFCAP;
		vertices = (T[]) new Object[DEFCAP];
		marks = new boolean[DEFCAP];
		edges = new int[DEFCAP][DEFCAP];

	}

	// Instantiates a graph with capacity maxV.
	public UndirectedGraph(int maxV) {

		numVertices = 0;
		maxVertices = maxV;
		vertices = (T[]) new Object[maxV];
		marks = new boolean[maxV];
		edges = new int[maxV][maxV];

	}

	// Returns true if this graph is empty; otherwise, returns false.
	public boolean isEmpty() {

		return (numVertices == 0);

	}

	// Returns true if this graph is full; otherwise, returns false.
	public boolean isFull() {

		return (numVertices==maxVertices);

	}

	// Preconditions:   This graph is not full.
	//                  vertex is not already in this graph.
	//                  vertex is not null.
	//
	// Adds vertex to this graph.
	public void addVertex(T vertex) {

		vertices[numVertices] = vertex;

		for(int i = 0; i < numVertices; i++) {

			edges[numVertices][i] = NULL_EDGE;
			edges[i][numVertices] = NULL_EDGE;

		}

		numVertices++;

	}

	// Returns true if this graph contains vertex; otherwise, returns false.
	public boolean hasVertex(T vertex) {

		for(int i = 0; i < vertices.length; i++) {

			if(vertices[i] == null) {

				return false;

			}

			if(vertices[i].equals(vertex)) {

				return true;

			}

		}

		return false;

	}

	// Returns the index of vertex in vertices.
	private int indexIs(T vertex) {

		int index = 0;
		while (index < vertices.length) {

			if(vertex.equals(vertices[index]))
				break;

			index++;

		}


		if(index == vertices.length)
			return -1;

		return index;

	}

	// Adds an edge from fromVertex to toVertex.
	//Because this graph is undirected, it adds an edge in both directions.
	public void addEdge(T vertex1, T vertex2) {

		if(hasVertex(vertex1) && hasVertex(vertex2)) {

			edges[indexIs(vertex1)][indexIs(vertex2)] = 1;
			edges[indexIs(vertex2)][indexIs(vertex1)] = 1;

		}

	}

	// Returns a queue of the vertices that vertex is adjacent to.
	public Queue<T> getToVertices(T vertex) {

		Queue<T> adjVertices = new ArrayDeque<T>();
		int fromIndex;
		int toIndex;
		fromIndex = indexIs(vertex);

		for (toIndex = 0; toIndex < numVertices; toIndex++)
			if (edges[fromIndex][toIndex] != NULL_EDGE)
				adjVertices.add(vertices[toIndex]);

		return adjVertices;

	}

	// Unmarks all vertices.
	public void clearMarks() {

		for(boolean mark : marks) {

			mark = false;

		}

	}

	// Marks vertex.
	public void markVertex(T vertex) {

		if(hasVertex(vertex)) {

			marks[indexIs(vertex)] = true;

		}

	}

	// Returns true if vertex is marked; otherwise, returns false.
	public boolean isMarked(T vertex) {

		if(hasVertex(vertex)) {

			if(marks[indexIs(vertex)])

				return true;

		}

		return false;

	}

	// Returns an unmarked vertex if any exist; otherwise, returns null.
	public T getUnmarked() {

		int index = -1;

		for(int i = 0; i < marks.length; i++) {

			if(!marks[i]) {

				index = i;
				break;

			}

		}

		if(index >= 0)
			return vertices[index];

		return null;

	}

	// Preconditions:  vertex1 and vertex2 are in the set of vertices
	//
	// Return value = (vertex1, vertex2) is in the set of edges
	public boolean edgeExists(T vertex1, T vertex2) {

		return (edges[indexIs(vertex1)][indexIs(vertex2)] != NULL_EDGE);

	}

	// Preconditions:  vertex1 and vertex2 are in the set of vertices
	//
	// Return value = true if edge was in the graph (and has been removed)
	//              = false if edge was not in the graph
	public boolean removeEdge(T vertex1, T vertex2) {

		boolean existed = edgeExists(vertex1, vertex2);
		edges[indexIs(vertex1)][indexIs(vertex2)] = NULL_EDGE;
		edges[indexIs(vertex2)][indexIs(vertex1)] = NULL_EDGE;

		return existed;

	}

}
