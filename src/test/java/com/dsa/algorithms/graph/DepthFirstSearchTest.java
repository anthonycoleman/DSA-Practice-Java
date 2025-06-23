package com.dsa.algorithms.graph;

import com.dsa.datastructures.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Tests for Depth-First Search (DFS) algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "DepthFirstSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.graph.DepthFirstSearchTest"
 * ./gradlew test --tests "*DepthFirstSearch*"
 * ./gradlew test --tests "*DFS*"
 */
class DepthFirstSearchTest {
    
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
    void testDFS_UndirectedGraph_VisitsAllConnectedNodes() {
        List<String> result = DepthFirstSearch.dfs(undirectedGraph, "A");
        
        assertEquals(5, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        
        assertEquals("A", result.get(0));
    }
    
    @Test
    void testDFS_DirectedGraph_VisitsReachableNodes() {
        List<String> result = DepthFirstSearch.dfs(directedGraph, "A");
        
        assertEquals(5, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        
        assertEquals("A", result.get(0));
    }
    
    @Test
    void testDFS_SingleNode_ReturnsSingleNode() {
        Graph<String> singleNode = new Graph<>(false);
        singleNode.addVertex("X");
        
        List<String> result = DepthFirstSearch.dfs(singleNode, "X");
        
        assertEquals(1, result.size());
        assertEquals("X", result.get(0));
    }
    
    @Test
    void testDFS_NullGraph_ReturnsEmptyList() {
        List<String> result = DepthFirstSearch.dfs(null, "A");
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testDFS_NullStartVertex_ReturnsEmptyList() {
        List<String> result = DepthFirstSearch.dfs(undirectedGraph, null);
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testDFS_NonExistentStartVertex_ReturnsEmptyList() {
        List<String> result = DepthFirstSearch.dfs(undirectedGraph, "Z");
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testDFS_DisconnectedGraph_OnlyVisitsConnectedComponent() {
        Graph<String> disconnected = new Graph<>(false);
        disconnected.addEdge("A", "B");
        disconnected.addEdge("C", "D");
        
        List<String> result = DepthFirstSearch.dfs(disconnected, "A");
        
        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertFalse(result.contains("C"));
        assertFalse(result.contains("D"));
    }
    
    @Test
    void testDFS_LinearGraph_VisitsInDepthFirstOrder() {
        Graph<String> linear = new Graph<>(false);
        linear.addEdge("A", "B");
        linear.addEdge("B", "C");
        linear.addEdge("C", "D");
        
        List<String> result = DepthFirstSearch.dfs(linear, "A");
        
        assertEquals(4, result.size());
        assertEquals("A", result.get(0));
        // Should go deep before backtracking
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
    }
    
    @Test
    void testDFS_TreeStructure_VisitsInDepthFirstOrder() {
        Graph<String> tree = new Graph<>(false);
        tree.addEdge("Root", "Left");
        tree.addEdge("Root", "Right");
        tree.addEdge("Left", "LeftLeft");
        tree.addEdge("Left", "LeftRight");
        
        List<String> result = DepthFirstSearch.dfs(tree, "Root");
        
        assertEquals(5, result.size());
        assertEquals("Root", result.get(0));
        // Should explore one subtree completely before the other
        assertTrue(result.contains("Left"));
        assertTrue(result.contains("Right"));
        assertTrue(result.contains("LeftLeft"));
        assertTrue(result.contains("LeftRight"));
    }
    
    @Test
    void testDFS_SelfLoop_HandlesCorrectly() {
        Graph<String> withSelfLoop = new Graph<>(false);
        withSelfLoop.addEdge("A", "A"); // Self-loop
        withSelfLoop.addEdge("A", "B");
        
        List<String> result = DepthFirstSearch.dfs(withSelfLoop, "A");
        
        assertEquals(2, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
    }
    
    @Test
    void testDFSRecursive_UndirectedGraph_VisitsAllConnectedNodes() {
        List<String> result = DepthFirstSearch.dfsRecursive(undirectedGraph, "A");
        
        assertEquals(5, result.size());
        assertTrue(result.contains("A"));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        
        assertEquals("A", result.get(0));
    }
    
    @Test
    void testDFSRecursive_NullGraph_ReturnsEmptyList() {
        List<String> result = DepthFirstSearch.dfsRecursive(null, "A");
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testBFSvsDFS_SameGraph_VisitsSameNodes() {
        List<String> bfsResult = BreadthFirstSearch.bfs(undirectedGraph, "A");
        List<String> dfsResult = DepthFirstSearch.dfs(undirectedGraph, "A");
        List<String> dfsRecursiveResult = DepthFirstSearch.dfsRecursive(undirectedGraph, "A");
        
        assertEquals(bfsResult.size(), dfsResult.size());
        assertEquals(bfsResult.size(), dfsRecursiveResult.size());
        
        // All should visit the same nodes (though in different orders)
        for (String node : bfsResult) {
            assertTrue(dfsResult.contains(node));
            assertTrue(dfsRecursiveResult.contains(node));
        }
    }
}