package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Tests for Binary Search Tree data structure
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "BinarySearchTreeTest"
 * ./gradlew test --tests "com.dsa.datastructures.BinarySearchTreeTest"
 * ./gradlew test --tests "*BinarySearchTree*"
 * ./gradlew test --tests "*BST*"
 */
class BinarySearchTreeTest {
    
    private BinarySearchTree<Integer> bst;
    
    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }
    
    @Test
    void testNewBST_IsEmpty() {
        assertTrue(bst.isEmpty());
    }
    
    @Test
    void testInsert_SingleElement_NotEmpty() {
        bst.insert(5);
        assertFalse(bst.isEmpty());
        assertTrue(bst.search(5));
    }
    
    @Test
    void testInsert_MultipleElements_MaintainsBSTProperty() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(1));
        assertTrue(bst.search(4));
    }
    
    @Test
    void testSearch_NonExistentElement_ReturnsFalse() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        
        assertFalse(bst.search(2));
        assertFalse(bst.search(6));
        assertFalse(bst.search(10));
    }
    
    @Test
    void testSearch_EmptyTree_ReturnsFalse() {
        assertFalse(bst.search(5));
    }
    
    @Test
    void testInOrderTraversal_ReturnsElementsInSortedOrder() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        
        List<Integer> result = bst.inOrderTraversal();
        assertEquals(List.of(1, 3, 4, 5, 6, 7, 8), result);
    }
    
    @Test
    void testPreOrderTraversal_ReturnsCorrectOrder() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        
        List<Integer> result = bst.preOrderTraversal();
        assertEquals(List.of(5, 3, 1, 4, 7), result);
    }
    
    @Test
    void testPostOrderTraversal_ReturnsCorrectOrder() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        
        List<Integer> result = bst.postOrderTraversal();
        assertEquals(List.of(1, 4, 3, 7, 5), result);
    }
    
    @Test
    void testDelete_LeafNode_RemovesCorrectly() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        
        bst.delete(1);
        assertFalse(bst.search(1));
        assertTrue(bst.search(3));
        assertTrue(bst.search(5));
        assertTrue(bst.search(7));
    }
    
    @Test
    void testDelete_NodeWithOneChild_RemovesCorrectly() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        
        bst.delete(7); // Node with one left child
        assertFalse(bst.search(7));
        assertTrue(bst.search(6));
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
    }
    
    @Test
    void testDelete_NodeWithTwoChildren_RemovesCorrectly() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        
        bst.delete(5); // Root node with two children
        assertFalse(bst.search(5));
        
        // All other elements should still be present
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
        assertTrue(bst.search(1));
        assertTrue(bst.search(4));
        assertTrue(bst.search(6));
        assertTrue(bst.search(8));
        
        // Tree should maintain BST property
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(1, 3, 4, 6, 7, 8), inOrder);
    }
    
    @Test
    void testDelete_NonExistentElement_NoChange() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        
        bst.delete(10); // Element doesn't exist
        
        assertTrue(bst.search(5));
        assertTrue(bst.search(3));
        assertTrue(bst.search(7));
    }
    
    @Test
    void testDelete_EmptyTree_NoException() {
        assertDoesNotThrow(() -> bst.delete(5));
    }
    
    @Test
    void testInsertDuplicates_NoDuplicatesInserted() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(5); // Duplicate
        bst.insert(3); // Duplicate
        
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(3, 5), inOrder);
    }
    
    @Test
    void testTraversalOnEmptyTree_ReturnsEmptyList() {
        List<Integer> inOrder = bst.inOrderTraversal();
        List<Integer> preOrder = bst.preOrderTraversal();
        List<Integer> postOrder = bst.postOrderTraversal();
        
        assertTrue(inOrder.isEmpty());
        assertTrue(preOrder.isEmpty());
        assertTrue(postOrder.isEmpty());
    }
    
    @Test
    void testWithStrings_WorksCorrectly() {
        BinarySearchTree<String> stringBst = new BinarySearchTree<>();
        
        stringBst.insert("dog");
        stringBst.insert("cat");
        stringBst.insert("elephant");
        stringBst.insert("bird");
        
        List<String> inOrder = stringBst.inOrderTraversal();
        assertEquals(List.of("bird", "cat", "dog", "elephant"), inOrder);
        
        assertTrue(stringBst.search("cat"));
        assertFalse(stringBst.search("fish"));
    }
    
    @Test
    void testSequentialInsertions_CreatesBalancedLookingTree() {
        // Insert in order that should create a more balanced tree
        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int value : values) {
            bst.insert(value);
        }
        
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), inOrder);
        
        for (int value : values) {
            assertTrue(bst.search(value));
        }
    }
    
    @Test
    void testComplexDeleteSequence_MaintainsBSTProperty() {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        for (int value : values) {
            bst.insert(value);
        }
        
        // Delete nodes with different child configurations
        bst.delete(10); // Leaf
        bst.delete(25); // Leaf
        bst.delete(20); // Node with one child
        bst.delete(30); // Node with two children
        
        // Verify remaining elements maintain BST property
        List<Integer> inOrder = bst.inOrderTraversal();
        for (int i = 1; i < inOrder.size(); i++) {
            assertTrue(inOrder.get(i - 1) < inOrder.get(i));
        }
        
        // Verify deleted elements are gone
        assertFalse(bst.search(10));
        assertFalse(bst.search(25));
        assertFalse(bst.search(20));
        assertFalse(bst.search(30));
        
        // Verify remaining elements are still there
        assertTrue(bst.search(50));
        assertTrue(bst.search(40));
        assertTrue(bst.search(35));
        assertTrue(bst.search(45));
    }
    
    @Test
    void testBSTWithExtremeValues_HandlesCorrectly() {
        bst.insert(Integer.MAX_VALUE);
        bst.insert(Integer.MIN_VALUE);
        bst.insert(0);
        bst.insert(-1);
        bst.insert(1);
        
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE), inOrder);
        
        assertTrue(bst.search(Integer.MAX_VALUE));
        assertTrue(bst.search(Integer.MIN_VALUE));
    }
    
    @Test
    void testSkewedBST_RightSkewed_WorksCorrectly() {
        // Insert in ascending order (creates right-skewed tree)
        for (int i = 1; i <= 10; i++) {
            bst.insert(i);
        }
        
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), inOrder);
        
        // Should still be able to search efficiently
        assertTrue(bst.search(1));
        assertTrue(bst.search(10));
        assertTrue(bst.search(5));
        assertFalse(bst.search(11));
    }
    
    @Test
    void testSkewedBST_LeftSkewed_WorksCorrectly() {
        // Insert in descending order (creates left-skewed tree)
        for (int i = 10; i >= 1; i--) {
            bst.insert(i);
        }
        
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), inOrder);
        
        // Should still be able to search efficiently
        assertTrue(bst.search(1));
        assertTrue(bst.search(10));
        assertTrue(bst.search(5));
        assertFalse(bst.search(0));
    }
    
    @Test
    void testBSTDeleteRootMultipleTimes_HandlesCorrectly() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        
        // Delete root multiple times
        bst.delete(50); // Delete original root
        assertFalse(bst.search(50));
        
        // Tree should still be valid BST
        List<Integer> inOrder = bst.inOrderTraversal();
        for (int i = 1; i < inOrder.size(); i++) {
            assertTrue(inOrder.get(i - 1) < inOrder.get(i));
        }
        
        // Delete new root and verify again
        Integer newRoot = inOrder.get(inOrder.size() / 2); // Get middle element
        bst.delete(newRoot);
        
        List<Integer> newInOrder = bst.inOrderTraversal();
        for (int i = 1; i < newInOrder.size(); i++) {
            assertTrue(newInOrder.get(i - 1) < newInOrder.get(i));
        }
    }
    
    @Test
    void testLargeBST_Performance_WorksCorrectly() {
        // Insert many elements
        for (int i = 0; i < 1000; i++) {
            bst.insert(i * 2); // Even numbers
        }
        
        // Search for various elements
        assertTrue(bst.search(0));
        assertTrue(bst.search(500));
        assertTrue(bst.search(1998));
        assertFalse(bst.search(1)); // Odd number
        assertFalse(bst.search(2000)); // Too large
        
        // Verify in-order traversal is still sorted
        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(1000, inOrder.size());
        for (int i = 1; i < inOrder.size(); i++) {
            assertTrue(inOrder.get(i - 1) < inOrder.get(i));
        }
    }
}