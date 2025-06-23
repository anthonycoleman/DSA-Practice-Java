package com.dsa.algorithms.graph;

import com.dsa.datastructures.Graph;
import java.util.*;

/**
 * Depth-First Search (DFS) Implementation
 * 
 * Time Complexity: O(V + E) where V is vertices and E is edges
 * Space Complexity: O(V) for the stack and visited set
 * 
 * DFS explores a graph by going as deep as possible along each branch before backtracking.
 * This implementation uses an iterative approach with an explicit stack.
 * 
 * Use cases: Detecting cycles, topological sorting, finding connected components
 * 
 * Test this implementation:
 * ./gradlew test --tests "DepthFirstSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.graph.DepthFirstSearchTest"
 * ./gradlew test --tests "*DepthFirstSearch*"
 * ./gradlew test --tests "*DFS*"
 */
public class DepthFirstSearch {
    
    /**
     * Performs depth-first search traversal on a graph (iterative)
     * @param graph the graph to traverse
     * @param startVertex the vertex to start traversal from
     * @return list of vertices in DFS order
     */
    public static <T> List<T> dfs(Graph<T> graph, T startVertex) {
        if (graph == null || startVertex == null || !graph.containsVertex(startVertex)) {
            return new ArrayList<>();
        }
        
        // TODO: Implement iterative depth-first search algorithm
        // Hint: Use a stack to store vertices to visit and a set to track visited vertices
        // Go as deep as possible before backtracking
        return new ArrayList<>(); // Placeholder return value
    }
    
    /**
     * Performs depth-first search traversal on a graph (recursive)
     * @param graph the graph to traverse
     * @param startVertex the vertex to start traversal from
     * @return list of vertices in DFS order
     */
    public static <T> List<T> dfsRecursive(Graph<T> graph, T startVertex) {
        if (graph == null || startVertex == null || !graph.containsVertex(startVertex)) {
            return new ArrayList<>();
        }
        
        // TODO: Implement recursive depth-first search algorithm
        // Hint: Use a helper method with visited set and result list
        return new ArrayList<>(); // Placeholder return value
    }
    
    private static <T> void dfsHelper(Graph<T> graph, T vertex, Set<T> visited, List<T> result) {
        // TODO: Implement the recursive helper method
        // Hint: Mark vertex as visited, add to result, then recursively visit neighbors
    }
}