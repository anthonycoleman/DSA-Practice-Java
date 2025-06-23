package com.dsa.algorithms.graph;

import com.dsa.datastructures.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Tests for Breadth-First Search (BFS) algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "BreadthFirstSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.graph.BreadthFirstSearchTest"
 * ./gradlew test --tests "*BreadthFirstSearch*"
 * ./gradlew test --tests "*BFS*"
 */
class BreadthFirstSearchTest {
    
    private Graph<String> undirectedGraph;
    private Graph<String> directedGraph;
    
    @BeforeEach
    void setUp() {
        // Create undirected graph: A - B - C
        //                         |   |
        //                         D - E
        undirectedGraph = new Graph<>(false);
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("A", "D");
        undirectedGraph.addEdge("B", "C");
        undirectedGraph.addEdge("B", "E");
        undirectedGraph.addEdge("D", "E");
        
        // Create directed graph: A -> B -> C
        //                        |    |
        //                        v    v
        //                        D -> E
        directedGraph = new Graph<>(true);
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("A", "D");
        directedGraph.addEdge("B", "C");
        directedGraph.addEdge("B", "E");
        directedGraph.addEdge("D", "E");
    }
    
    @Test
    void testBFS_UndirectedGraph_VisitsAllConnectedNodes() {
        List<String> result = BreadthFirstSearch.bfs(undirectedGraph, "A");
        
        assertEquals(5, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        
        // A should be first (starting node)
        assertEquals("A", result.get(0));
    }
    
    @Test
    void testBFS_DirectedGraph_VisitsReachableNodes() {
        List<String> result = BreadthFirstSearch.bfs(directedGraph, "A");
        
        assertEquals(5, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        
        assertEquals("A", result.get(0));
    }
    
    @Test
    void testBFS_StartFromDifferentNode_WorksCorrectly() {
        List<String> result = BreadthFirstSearch.bfs(undirectedGraph, "C");
        
        assertEquals(5, result.size());
        assertEquals("C", result.get(0));
    }
    
    @Test
    void testBFS_SingleNode_ReturnsSingleNode() {
        Graph<String> singleNode = new Graph<>(false);
        singleNode.addVertex("X");
        
        List<String> result = BreadthFirstSearch.bfs(singleNode, "X");
        
        assertEquals(1, result.size());
        assertEquals("X", result.get(0));
    }
    
    @Test
    void testBFS_NullGraph_ReturnsEmptyList() {
        List<String> result = BreadthFirstSearch.bfs(null, "A");
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testBFS_NullStartVertex_ReturnsEmptyList() {
        List<String> result = BreadthFirstSearch.bfs(undirectedGraph, null);
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testBFS_NonExistentStartVertex_ReturnsEmptyList() {
        List<String> result = BreadthFirstSearch.bfs(undirectedGraph, "Z");
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testBFS_DisconnectedGraph_OnlyVisitsConnectedComponent() {
        Graph<String> disconnected = new Graph<>(false);
        disconnected.addEdge("A", "B");
        disconnected.addEdge("C", "D");
        
        List<String> result = BreadthFirstSearch.bfs(disconnected, "A");
        
        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertFalse(result.contains("C"));
        assertFalse(result.contains("D"));
    }
    
    @Test
    void testBFS_LinearGraph_VisitsInCorrectOrder() {
        Graph<String> linear = new Graph<>(false);
        linear.addEdge("A", "B");
        linear.addEdge("B", "C");
        linear.addEdge("C", "D");
        
        List<String> result = BreadthFirstSearch.bfs(linear, "A");
        
        assertEquals(4, result.size());
        assertEquals("A", result.get(0));
        // B should come before C and D
        assertTrue(result.indexOf("B") < result.indexOf("C"));
        assertTrue(result.indexOf("C") < result.indexOf("D"));
    }
    
    @Test
    void testBFS_StarGraph_VisitsInBreadthFirstOrder() {
        Graph<String> star = new Graph<>(false);
        star.addEdge("Center", "A");
        star.addEdge("Center", "B");
        star.addEdge("Center", "C");
        star.addEdge("Center", "D");
        
        List<String> result = BreadthFirstSearch.bfs(star, "Center");
        
        assertEquals(5, result.size());
        assertEquals("Center", result.get(0));
        // All other nodes should be at the same level (distance 1)
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
    }
    
    @Test
    void testBFS_SelfLoop_HandlesCorrectly() {
        Graph<String> withSelfLoop = new Graph<>(false);
        withSelfLoop.addEdge("A", "A"); // Self-loop
        withSelfLoop.addEdge("A", "B");
        
        List<String> result = BreadthFirstSearch.bfs(withSelfLoop, "A");
        
        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
    }
}