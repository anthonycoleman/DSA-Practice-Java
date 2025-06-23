package com.dsa.algorithms;

import com.dsa.datastructures.Graph;
import java.util.*;

/**
 * Implementation of graph traversal algorithms
 */
public class GraphTraversals {
    
    /**
     * Breadth-First Search traversal
     * Time: O(V + E), Space: O(V)
     * @param graph the graph to traverse
     * @param startVertex the starting vertex
     * @return list of visited vertices in BFS order
     */
    public static <T> List<T> bfs(Graph<T> graph, T startVertex) {
        if (graph == null || startVertex == null || !graph.containsVertex(startVertex)) {
            return new ArrayList<>();
        }
        
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        
        queue.offer(startVertex);
        visited.add(startVertex);
        
        while (!queue.isEmpty()) {
            T current = queue.poll();
            result.add(current);
            
            for (T neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return result;
    }
    
    /**
     * Depth-First Search traversal (iterative)
     * Time: O(V + E), Space: O(V)
     * @param graph the graph to traverse
     * @param startVertex the starting vertex
     * @return list of visited vertices in DFS order
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
     * Depth-First Search traversal (recursive)
     * Time: O(V + E), Space: O(V)
     * @param graph the graph to traverse
     * @param startVertex the starting vertex
     * @return list of visited vertices in DFS order
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
    
    /**
     * Check if there's a path between two vertices using BFS
     * @param graph the graph to search in
     * @param start the starting vertex
     * @param end the target vertex
     * @return true if path exists, false otherwise
     */
    public static <T> boolean hasPath(Graph<T> graph, T start, T end) {
        if (graph == null || start == null || end == null) {
            return false;
        }
        
        if (start.equals(end)) {
            return graph.containsVertex(start);
        }
        
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        
        queue.offer(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            T current = queue.poll();
            
            if (current.equals(end)) {
                return true;
            }
            
            for (T neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        return false;
    }
}