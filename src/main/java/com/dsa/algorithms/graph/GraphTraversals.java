package com.dsa.algorithms.graph;

import com.dsa.datastructures.graph.Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;
import java.util.Collections;

public class GraphTraversals {

    /**
     * Performs a Breadth-First Search (BFS) on a graph starting from a given vertex.
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> bfs(Graph<T> graph, T startVertex) {
        // TODO: Implement Breadth-First Search.
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Or throw, based on contract
        }
        // Implementation details:
        // Use a Queue to manage vertices to visit.
        // Use a Set to keep track of visited vertices.
        // Start with the startVertex, add to queue and visited set.
        // While queue is not empty, dequeue a vertex, add to result list.
        // For each unvisited neighbor, mark as visited and enqueue.
        return new ArrayList<>(); // Placeholder
    }

    /**
     * Performs a Depth-First Search (DFS) on a graph starting from a given vertex.
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> dfs(Graph<T> graph, T startVertex) { // Iterative DFS
        // TODO: Implement Depth-First Search (Iterative).
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Or throw, based on contract
        }
        // Implementation details:
        // Use a Stack to manage vertices to visit.
        // Use a Set to keep track of visited vertices.
        // Start with the startVertex, push to stack.
        // While stack is not empty, pop a vertex.
        // If not visited, mark as visited, add to result list.
        // Push all unvisited neighbors onto the stack.
        return new ArrayList<>(); // Placeholder
    }

    /**
     * Performs a Depth-First Search (DFS) on a graph starting from a given vertex (Recursive version).
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> dfsRecursive(Graph<T> graph, T startVertex) {
        // TODO: Implement Depth-First Search (Recursive) - public facing method.
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Or throw, based on contract
        }
        // This method will initialize the visited set and result list,
        // then call the private recursive helper function.
        List<T> visitedOrder = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        // dfsRecursiveHelper(graph, startVertex, visited, visitedOrder); // Call to helper will be in actual impl
        return visitedOrder; // Placeholder, or populated by helper in actual impl
    }

    private static <T> void dfsRecursiveHelper(Graph<T> graph, T currentVertex, Set<T> visited, List<T> visitedOrder) {
        // TODO: Implement the recursive helper for DFS.
        // Mark currentVertex as visited and add to visitedOrder list.
        // For each unvisited neighbor of currentVertex:
        //   Recursively call this helper function with the neighbor.
        // Base case: if currentVertex is already visited, or no unvisited neighbors, return.
    }
}
