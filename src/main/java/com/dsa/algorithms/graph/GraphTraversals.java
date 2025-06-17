package com.dsa.algorithms.graph;

import com.dsa.datastructures.graph.Graph;
import java.util.List;

public class GraphTraversals {

    /**
     * Performs a Breadth-First Search (BFS) on a graph starting from a given vertex.
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> bfs(Graph<T> graph, T startVertex) {
        // TODO: Implement Breadth-First Search
        // You will need a Queue and a Set to keep track of visited nodes.
        return null;
    }

    /**
     * Performs a Depth-First Search (DFS) on a graph starting from a given vertex.
     * @param graph The graph to traverse.
     * @param startVertex The vertex to start the traversal from.
     * @param <T> The type of data in the graph's vertices.
     * @return A list of vertices in the order they were visited.
     */
    public static <T> List<T> dfs(Graph<T> graph, T startVertex) {
        // TODO: Implement Depth-First Search
        // You can implement this iteratively with a Stack or recursively.
        // A Set will be needed to keep track of visited nodes.
        return null;
    }
}
