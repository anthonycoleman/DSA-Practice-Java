package com.dsa.datastructures.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Represents a graph using an adjacency list.
 * Can be directed or undirected.
 * @param <T> The type of data held in the vertices.
 */
public class Graph<T> {

    private final Map<T, List<T>> adjacencyList;
    private final boolean isDirected;

    /**
     * Constructs a new graph.
     * @param isDirected true if the graph is directed, false otherwise.
     */
    public Graph(boolean isDirected) {
        this.adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to add.
     */
    public void addVertex(T vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null.");
        }
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    /**
     * Adds an edge between two vertices.
     * If the graph is undirected, an edge is added in both directions.
     * @param source The source vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(T source, T destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination vertices cannot be null.");
        }
        // Ensure vertices exist in the graph, add them if they don't
        addVertex(source);
        addVertex(destination);

        // Add edge from source to destination
        adjacencyList.get(source).add(destination);

        // If undirected, add edge from destination to source as well
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }

    /**
     * Gets all vertices in the graph.
     * @return A set containing all vertices.
     */
    public Set<T> getVertices() {
        return adjacencyList.keySet();
    }

    /**
     * Gets the neighbors of a given vertex.
     * @param vertex The vertex whose neighbors to get.
     * @return A list of neighboring vertices.
     */
    public List<T> getNeighbors(T vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Vertex cannot be null.");
        }
        if (!adjacencyList.containsKey(vertex)) {
            return null;
        }
        return adjacencyList.get(vertex);
    }

    /**
     * Gets the number of vertices in the graph.
     * @return The number of vertices.
     */
    public int getVertexCount() {
        return adjacencyList.size();
    }
}
