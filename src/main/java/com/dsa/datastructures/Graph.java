package com.dsa.datastructures;

import java.util.*;

/**
 * Generic Graph implementation using adjacency list representation
 * @param <T> the type of vertices stored in this graph
 */
public class Graph<T> {
    private final Map<T, List<T>> adjacencyList;
    private final boolean isDirected;
    
    /**
     * Constructor
     * @param isDirected true for directed graph, false for undirected
     */
    public Graph(boolean isDirected) {
        this.adjacencyList = new HashMap<>();
        this.isDirected = isDirected;
    }
    
    /**
     * Add vertex to graph
     * @param vertex vertex to add
     */
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }
    
    /**
     * Add edge between two vertices
     * @param source source vertex
     * @param destination destination vertex
     */
    public void addEdge(T source, T destination) {
        // Add vertices if they don't exist
        addVertex(source);
        addVertex(destination);
        
        // Add edge from source to destination
        adjacencyList.get(source).add(destination);
        
        // If undirected, add edge from destination to source
        if (!isDirected) {
            adjacencyList.get(destination).add(source);
        }
    }
    
    /**
     * Get all vertices in graph
     * @return set of all vertices
     */
    public Set<T> getVertices() {
        return new HashSet<>(adjacencyList.keySet());
    }
    
    /**
     * Get neighbors of specified vertex
     * @param vertex vertex to get neighbors for
     * @return list of neighbors, or empty list if vertex doesn't exist
     */
    public List<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
    
    /**
     * Get total number of vertices
     * @return number of vertices
     */
    public int getVertexCount() {
        return adjacencyList.size();
    }
    
    /**
     * Check if graph contains a vertex
     * @param vertex vertex to check
     * @return true if vertex exists, false otherwise
     */
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }
    
    /**
     * Check if there's an edge between two vertices
     * @param source source vertex
     * @param destination destination vertex
     * @return true if edge exists, false otherwise
     */
    public boolean hasEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source)) {
            return false;
        }
        return adjacencyList.get(source).contains(destination);
    }
    
    /**
     * Remove vertex and all its edges
     * @param vertex vertex to remove
     */
    public void removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return;
        }
        
        // Remove all edges to this vertex
        for (List<T> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }
        
        // Remove the vertex itself
        adjacencyList.remove(vertex);
    }
    
    /**
     * Remove edge between two vertices
     * @param source source vertex
     * @param destination destination vertex
     */
    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        
        if (!isDirected && adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }
    }
}