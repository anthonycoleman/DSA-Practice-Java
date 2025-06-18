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
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            // Or throw IllegalArgumentException, or return empty list based on desired contract
            return Collections.emptyList(); 
        }

        List<T> visitedOrder = new ArrayList<>();
        Queue<T> queue = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            visitedOrder.add(current);

            for (T neighbor : graph.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return visitedOrder;
    }

    /**
     * Performs a Depth-First Search (DFS) on a graph starting from a given vertex.
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> dfs(Graph<T> graph, T startVertex) { // Iterative DFS
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList();
        }

        List<T> visitedOrder = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        Set<T> visited = new HashSet<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                visitedOrder.add(current);

                // Push neighbors in reverse order to visit them in natural order (optional)
                List<T> neighbors = graph.getNeighbors(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    T neighbor = neighbors.get(i);
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return visitedOrder;
    }

    /**
     * Performs a Depth-First Search (DFS) on a graph starting from a given vertex (Recursive version).
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> dfsRecursive(Graph<T> graph, T startVertex) {
        if (graph == null || startVertex == null || !graph.getVertices().contains(startVertex)) {
            return Collections.emptyList();
        }
        List<T> visitedOrder = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        dfsRecursiveHelper(graph, startVertex, visited, visitedOrder);
        return visitedOrder;
    }

    private static <T> void dfsRecursiveHelper(Graph<T> graph, T currentVertex, Set<T> visited, List<T> visitedOrder) {
        visited.add(currentVertex);
        visitedOrder.add(currentVertex);

        for (T neighbor : graph.getNeighbors(currentVertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursiveHelper(graph, neighbor, visited, visitedOrder);
            }
        }
    }
}
