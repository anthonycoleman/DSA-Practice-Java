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
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        
        stack.push(startVertex);
        
        while (!stack.isEmpty()) {
            T current = stack.pop();
            
            if (!visited.contains(current)) {
                visited.add(current);
                result.add(current);
                
                // Add neighbors in reverse order to maintain left-to-right traversal
                List<T> neighbors = new ArrayList<>(graph.getNeighbors(current));
                Collections.reverse(neighbors);
                for (T neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        
        return result;
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
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        dfsHelper(graph, startVertex, visited, result);
        return result;
    }
    
    private static <T> void dfsHelper(Graph<T> graph, T vertex, Set<T> visited, List<T> result) {
        visited.add(vertex);
        result.add(vertex);
        
        for (T neighbor : graph.getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(graph, neighbor, visited, result);
            }
        }
    }
}