package com.dsa.algorithms.graph;

import com.dsa.datastructures.Graph;
import java.util.*;

/**
 * Breadth-First Search (BFS) Implementation
 * 
 * Time Complexity: O(V + E) where V is vertices and E is edges
 * Space Complexity: O(V) for the queue and visited set
 * 
 * BFS explores a graph level by level, visiting all neighbors of a vertex before
 * moving to the next level. It uses a queue to keep track of vertices to visit.
 * 
 * Use cases: Shortest path in unweighted graphs, level-order traversal
 * 
 * Test this implementation:
 * ./gradlew test --tests "BreadthFirstSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.graph.BreadthFirstSearchTest"
 * ./gradlew test --tests "*BreadthFirstSearch*"
 * ./gradlew test --tests "*BFS*"
 */
public class BreadthFirstSearch {
    
    /**
     * Performs breadth-first search traversal on a graph
     * @param graph the graph to traverse
     * @param startVertex the vertex to start traversal from
     * @return list of vertices in BFS order
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
}