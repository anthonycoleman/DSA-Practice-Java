package com.dsa.datastructures.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

public class GraphTest {

    @Test
    void testAddVertexAndGetVertices() {
        Graph<String> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        assertEquals(2, graph.getVertexCount());
        assertEquals(new HashSet<>(Arrays.asList("A", "B")), graph.getVertices());
    }

    @Test
    void testAddEdgeDirected() {
        Graph<Integer> graph = new Graph<>(true); // Directed
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);

        assertNotNull(graph.getNeighbors(1));
        assertTrue(graph.getNeighbors(1).contains(2), "Edge 1 -> 2 should exist");
        assertNotNull(graph.getNeighbors(2));
        assertFalse(graph.getNeighbors(2).contains(1), "Edge 2 -> 1 should not exist in a directed graph");
    }

    @Test
    void testAddEdgeUndirected() {
        Graph<Integer> graph = new Graph<>(false); // Undirected
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);

        assertNotNull(graph.getNeighbors(1));
        assertTrue(graph.getNeighbors(1).contains(2), "Edge 1 -> 2 should exist");
        assertNotNull(graph.getNeighbors(2));
        assertTrue(graph.getNeighbors(2).contains(1), "Edge 2 -> 1 should exist in an undirected graph");
    }

    @Test
    void testGetNeighbors() {
        Graph<Character> graph = new Graph<>(true);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');

        assertEquals(Arrays.asList('B', 'C'), graph.getNeighbors('A'));
        assertTrue(graph.getNeighbors('B').isEmpty());
        assertNull(graph.getNeighbors('Z'), "Getting neighbors of a non-existent vertex should return null");
    }
}
