package com.dsa.algorithms.graph;

import com.dsa.datastructures.graph.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class GraphTraversalsTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        // A simple directed graph for testing:
        // A -> B -> D
        // |    ^
        // v    |
        // C -> E
        graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("E", "B");
    }

    @Test
    void testBfs() {
        List<String> bfsOrder = GraphTraversals.bfs(graph, "A");
        List<String> expected = Arrays.asList("A", "B", "C", "D", "E");
        assertEquals(expected, bfsOrder, "BFS traversal order is incorrect");
    }

    @Test
    void testDfs() {
        List<String> dfsOrder = GraphTraversals.dfs(graph, "A");
        // DFS can have multiple valid paths. We'll check one common possibility.
        // A -> B -> D -> C -> E is one valid path.
        // A -> C -> E -> B -> D is another.
        // We check if the result is one of the valid paths.
        List<String> expected1 = Arrays.asList("A", "B", "D", "C", "E");
        List<String> expected2 = Arrays.asList("A", "C", "E", "B", "D");
        assertTrue(expected1.equals(dfsOrder) || expected2.equals(dfsOrder), "DFS traversal order is incorrect");
    }

    @Test
    void testBfsOnDisconnectedNode() {
        graph.addVertex("F");
        List<String> bfsOrder = GraphTraversals.bfs(graph, "A");
        assertEquals(5, bfsOrder.size(), "BFS should not visit disconnected nodes");
        assertFalse(bfsOrder.contains("F"));
    }

    @Test
    void testDfsOnDisconnectedNode() {
        graph.addVertex("F");
        List<String> dfsOrder = GraphTraversals.dfs(graph, "A");
        assertEquals(5, dfsOrder.size(), "DFS should not visit disconnected nodes");
        assertFalse(dfsOrder.contains("F"));
    }
}
