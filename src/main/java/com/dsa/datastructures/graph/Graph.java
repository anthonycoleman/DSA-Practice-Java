package com.dsa.datastructures.graph;

import java.util.List;
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
        // TODO: Initialize the adjacency list and set the directed flag
        this.adjacencyList = null; // Placeholder
        this.isDirected = isDirected;
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to add.
     */
    public void addVertex(T vertex) {
        // TODO: Implement addVertex
    }

    /**
     * Adds an edge between two vertices.
     * If the graph is undirected, an edge is added in both directions.
     * @param source The source vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(T source, T destination) {
        // TODO: Implement addEdge
    }

    /**
     * Gets all vertices in the graph.
     * @return A set containing all vertices.
     */
    public Set<T> getVertices() {
        // TODO: Implement getVertices
        return null;
    }

    /**
     * Gets the neighbors of a given vertex.
     * @param vertex The vertex whose neighbors to get.
     * @return A list of neighboring vertices.
     */
    public List<T> getNeighbors(T vertex) {
        // TODO: Implement getNeighbors
        return null;
    }

    /**
     * Gets the number of vertices in the graph.
     * @return The number of vertices.
     */
    public int getVertexCount() {
        // TODO: Implement getVertexCount
        return 0;
    }
}
