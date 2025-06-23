package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Set;

class GraphTest {
    
    private Graph<String> undirectedGraph;
    private Graph<String> directedGraph;
    
    @BeforeEach
    void setUp() {
        undirectedGraph = new Graph<>(false);
        directedGraph = new Graph<>(true);
    }
    
    @Test
    void testNewGraph_IsEmpty() {
        assertEquals(0, undirectedGraph.getVertexCount());
        assertEquals(0, directedGraph.getVertexCount());
        assertTrue(undirectedGraph.getVertices().isEmpty());
        assertTrue(directedGraph.getVertices().isEmpty());
    }
    
    @Test
    void testAddVertex_SingleVertex_IncrementsCount() {
        undirectedGraph.addVertex("A");
        
        assertEquals(1, undirectedGraph.getVertexCount());
        assertTrue(undirectedGraph.containsVertex("A"));
        assertTrue(undirectedGraph.getVertices().contains("A"));
    }
    
    @Test
    void testAddVertex_DuplicateVertex_NoIncrease() {
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("A");
        
        assertEquals(1, undirectedGraph.getVertexCount());
    }
    
    @Test
    void testAddEdge_UndirectedGraph_CreatesBidirectionalEdge() {
        undirectedGraph.addEdge("A", "B");
        
        assertEquals(2, undirectedGraph.getVertexCount());
        assertTrue(undirectedGraph.hasEdge("A", "B"));
        assertTrue(undirectedGraph.hasEdge("B", "A"));
        
        List<String> neighborsA = undirectedGraph.getNeighbors("A");
        List<String> neighborsB = undirectedGraph.getNeighbors("B");
        
        assertTrue(neighborsA.contains("B"));
        assertTrue(neighborsB.contains("A"));
    }
    
    @Test
    void testAddEdge_DirectedGraph_CreatesUnidirectionalEdge() {
        directedGraph.addEdge("A", "B");
        
        assertEquals(2, directedGraph.getVertexCount());
        assertTrue(directedGraph.hasEdge("A", "B"));
        assertFalse(directedGraph.hasEdge("B", "A"));
        
        List<String> neighborsA = directedGraph.getNeighbors("A");
        List<String> neighborsB = directedGraph.getNeighbors("B");
        
        assertTrue(neighborsA.contains("B"));
        assertFalse(neighborsB.contains("A"));
    }
    
    @Test
    void testGetNeighbors_NonExistentVertex_ReturnsEmptyList() {
        List<String> neighbors = undirectedGraph.getNeighbors("X");
        assertTrue(neighbors.isEmpty());
    }
    
    @Test
    void testGetNeighbors_VertexWithNoEdges_ReturnsEmptyList() {
        undirectedGraph.addVertex("A");
        List<String> neighbors = undirectedGraph.getNeighbors("A");
        assertTrue(neighbors.isEmpty());
    }
    
    @Test
    void testComplexGraph_UndirectedConnections() {
        // Create: A - B - C
        //         |   |
        //         D - E
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "D");
        undirectedGraph.addEdge("B", "C");
        undirectedGraph.addEdge("B", "E");
        undirectedGraph.addEdge("D", "E");
        
        assertEquals(5, undirectedGraph.getVertexCount());
        
        // Check A's neighbors
        List<String> neighborsA = undirectedGraph.getNeighbors("A");
        assertEquals(2, neighborsA.size());
        assertTrue(neighborsA.contains("B"));
        assertTrue(neighborsA.contains("D"));
        
        // Check B's neighbors
        List<String> neighborsB = undirectedGraph.getNeighbors("B");
        assertEquals(3, neighborsB.size());
        assertTrue(neighborsB.contains("A"));
        assertTrue(neighborsB.contains("C"));
        assertTrue(neighborsB.contains("E"));
    }
    
    @Test
    void testComplexGraph_DirectedConnections() {
        // Create: A -> B -> C
        //         |    |
        //         v    v
        //         D -> E
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "D");
        directedGraph.addEdge("B", "C");
        directedGraph.addEdge("B", "E");
        directedGraph.addEdge("D", "E");
        
        assertEquals(5, directedGraph.getVertexCount());
        
        // Check outgoing edges from A
        List<String> neighborsA = directedGraph.getNeighbors("A");
        assertEquals(2, neighborsA.size());
        assertTrue(neighborsA.contains("B"));
        assertTrue(neighborsA.contains("D"));
        
        // Check outgoing edges from E (should be empty)
        List<String> neighborsE = directedGraph.getNeighbors("E");
        assertTrue(neighborsE.isEmpty());
        
        // Verify directed nature
        assertTrue(directedGraph.hasEdge("A", "B"));
        assertFalse(directedGraph.hasEdge("B", "A"));
    }
    
    @Test
    void testRemoveVertex_RemovesVertexAndAllEdges() {
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "C");
        undirectedGraph.addEdge("B", "C");
        
        undirectedGraph.removeVertex("A");
        
        assertEquals(2, undirectedGraph.getVertexCount());
        assertFalse(undirectedGraph.containsVertex("A"));
        
        // Edges to A should be removed
        assertFalse(undirectedGraph.hasEdge("B", "A"));
        assertFalse(undirectedGraph.hasEdge("C", "A"));
        
        // Edge between B and C should remain
        assertTrue(undirectedGraph.hasEdge("B", "C"));
        assertTrue(undirectedGraph.hasEdge("C", "B"));
    }
    
    @Test
    void testRemoveVertex_NonExistentVertex_NoChange() {
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        
        undirectedGraph.removeVertex("C"); // Doesn't exist
        
        assertEquals(2, undirectedGraph.getVertexCount());
        assertTrue(undirectedGraph.containsVertex("A"));
        assertTrue(undirectedGraph.containsVertex("B"));
    }
    
    @Test
    void testRemoveEdge_UndirectedGraph_RemovesBothDirections() {
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "C");
        
        undirectedGraph.removeEdge("A", "B");
        
        assertFalse(undirectedGraph.hasEdge("A", "B"));
        assertFalse(undirectedGraph.hasEdge("B", "A"));
        assertTrue(undirectedGraph.hasEdge("A", "C"));
        assertTrue(undirectedGraph.hasEdge("C", "A"));
    }
    
    @Test
    void testRemoveEdge_DirectedGraph_RemovesOnlySpecifiedDirection() {
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("B", "A"); // Add reverse edge
        
        directedGraph.removeEdge("A", "B");
        
        assertFalse(directedGraph.hasEdge("A", "B"));
        assertTrue(directedGraph.hasEdge("B", "A")); // Reverse edge remains
    }
    
    @Test
    void testRemoveEdge_NonExistentEdge_NoChange() {
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        
        undirectedGraph.removeEdge("A", "B"); // Edge doesn't exist
        
        assertEquals(2, undirectedGraph.getVertexCount());
        assertFalse(undirectedGraph.hasEdge("A", "B"));
    }
    
    @Test
    void testGetVertices_ReturnsAllVertices() {
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        
        Set<String> vertices = undirectedGraph.getVertices();
        
        assertEquals(3, vertices.size());
        assertTrue(vertices.contains("A"));
        assertTrue(vertices.contains("B"));
        assertTrue(vertices.contains("C"));
    }
    
    @Test
    void testHasEdge_NonExistentVertices_ReturnsFalse() {
        assertFalse(undirectedGraph.hasEdge("A", "B"));
        
        undirectedGraph.addVertex("A");
        assertFalse(undirectedGraph.hasEdge("A", "B"));
        assertFalse(undirectedGraph.hasEdge("B", "A"));
    }
    
    @Test
    void testMultipleEdgesToSameVertex_WorksCorrectly() {
        // This tests that we can have multiple neighbors
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "C");
        undirectedGraph.addEdge("A", "D");
        
        List<String> neighbors = undirectedGraph.getNeighbors("A");
        assertEquals(3, neighbors.size());
        assertTrue(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
        assertTrue(neighbors.contains("D"));
    }
    
    @Test
    void testGenericType_WorksWithIntegers() {
        Graph<Integer> intGraph = new Graph<>(false);
        
        intGraph.addEdge(1, 2);
        intGraph.addEdge(2, 3);
        intGraph.addEdge(1, 3);
        
        assertEquals(3, intGraph.getVertexCount());
        assertTrue(intGraph.hasEdge(1, 2));
        assertTrue(intGraph.hasEdge(2, 3));
        assertTrue(intGraph.hasEdge(1, 3));
        
        List<Integer> neighbors1 = intGraph.getNeighbors(1);
        assertEquals(2, neighbors1.size());
        assertTrue(neighbors1.contains(2));
        assertTrue(neighbors1.contains(3));
    }
    
    @Test
    void testSelfLoop_WorksCorrectly() {
        undirectedGraph.addEdge("A", "A"); // Self-loop
        
        assertTrue(undirectedGraph.hasEdge("A", "A"));
        List<String> neighbors = undirectedGraph.getNeighbors("A");
        assertTrue(neighbors.contains("A"));
    }
    
    @Test
    void testGraphWithManyVertices_HandlesCorrectly() {
        // Create a graph with many vertices
        for (int i = 0; i < 1000; i++) {
            undirectedGraph.addVertex("vertex" + i);
        }
        
        assertEquals(1000, undirectedGraph.getVertexCount());
        
        // Add edges between consecutive vertices
        for (int i = 0; i < 999; i++) {
            undirectedGraph.addEdge("vertex" + i, "vertex" + (i + 1));
        }
        
        // Check some connections
        assertTrue(undirectedGraph.hasEdge("vertex0", "vertex1"));
        assertTrue(undirectedGraph.hasEdge("vertex500", "vertex501"));
        assertTrue(undirectedGraph.hasEdge("vertex998", "vertex999"));
    }
    
    @Test
    void testGraphWithDuplicateEdges_HandlesCorrectly() {
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "B"); // Duplicate
        undirectedGraph.addEdge("A", "B"); // Another duplicate
        
        List<String> neighborsA = undirectedGraph.getNeighbors("A");
        List<String> neighborsB = undirectedGraph.getNeighbors("B");
        
        // Should contain multiple references to the same neighbor
        long countB = neighborsA.stream().filter(n -> n.equals("B")).count();
        long countA = neighborsB.stream().filter(n -> n.equals("A")).count();
        
        assertTrue(countB >= 1); // At least one connection
        assertTrue(countA >= 1); // At least one connection
    }
    
    @Test
    void testEmptyStringVertices_WorksCorrectly() {
        undirectedGraph.addVertex("");
        undirectedGraph.addVertex("normal");
        undirectedGraph.addEdge("", "normal");
        
        assertEquals(2, undirectedGraph.getVertexCount());
        assertTrue(undirectedGraph.containsVertex(""));
        assertTrue(undirectedGraph.hasEdge("", "normal"));
        assertTrue(undirectedGraph.hasEdge("normal", ""));
    }
    
    @Test
    void testCompleteGraph_HandlesCorrectly() {
        // Create a complete graph with 5 vertices
        String[] vertices = {"A", "B", "C", "D", "E"};
        
        // Add all possible edges
        for (int i = 0; i < vertices.length; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                undirectedGraph.addEdge(vertices[i], vertices[j]);
            }
        }
        
        assertEquals(5, undirectedGraph.getVertexCount());
        
        // Verify each vertex is connected to all others
        for (String vertex : vertices) {
            List<String> neighbors = undirectedGraph.getNeighbors(vertex);
            assertEquals(4, neighbors.size()); // Connected to 4 others
        }
    }
    
    @Test
    void testDirectedGraphAsymmetry_WorksCorrectly() {
        // Test that directed graph maintains asymmetric relationships
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("B", "C");
        directedGraph.addEdge("C", "A");
        
        // Should form a directed cycle
        assertTrue(directedGraph.hasEdge("A", "B"));
        assertTrue(directedGraph.hasEdge("B", "C"));
        assertTrue(directedGraph.hasEdge("C", "A"));
        
        // But not the reverse edges
        assertFalse(directedGraph.hasEdge("B", "A"));
        assertFalse(directedGraph.hasEdge("C", "B"));
        assertFalse(directedGraph.hasEdge("A", "C"));
    }
}