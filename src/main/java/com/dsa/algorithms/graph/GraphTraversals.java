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
        // TODO: Implement Breadth-First Search (BFS).
        // Use a Queue to manage vertices to visit.
        // Use a Set to keep track of visited vertices to avoid cycles and redundant processing.
        // Start with the startVertex, add it to the queue and visited set.
        // While the queue is not empty, dequeue a vertex, add it to the result list.
        // For each unvisited neighbor, mark as visited and enqueue.
        // Handle null graph/startVertex or startVertex not in graph (e.g., return empty list or throw exception).
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Placeholder
        }
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
        // TODO: Implement iterative Depth-First Search (DFS).
        // Use a Stack to manage vertices to visit.
        // Use a Set to keep track of visited vertices.
        // Start with the startVertex, push it onto the stack.
        // While the stack is not empty, pop a vertex.
        // If not visited, mark as visited, add to result list, and push its unvisited neighbors onto the stack.
        // Consider the order of pushing neighbors if a specific traversal order is desired (e.g., reverse for natural order).
        // Handle null graph/startVertex or startVertex not in graph.
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Placeholder
        }
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
        // TODO: Implement recursive Depth-First Search (DFS) - public facing method.
        // This method will likely initialize a visited set and a result list,
        // then call a private recursive helper function.
        // Handle null graph/startVertex or startVertex not in graph.
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList(); // Placeholder
        }
        List<T> visitedOrder = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        // dfsRecursiveHelper(graph, startVertex, visited, visitedOrder); // Call to helper will be part of implementation
        return visitedOrder; // Placeholder
    }

    private static <T> void dfsRecursiveHelper(Graph<T> graph, T currentVertex, Set<T> visited, List<T> visitedOrder) {
        // TODO: Implement the recursive helper for DFS.
        // Mark the currentVertex as visited and add it to the visitedOrder list.
        // For each unvisited neighbor of currentVertex, make a recursive call to this helper.

    }
}
