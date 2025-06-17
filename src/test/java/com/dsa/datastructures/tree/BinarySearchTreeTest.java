package com.dsa.datastructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testNewTreeIsEmpty() {
        assertTrue(bst.isEmpty(), "A new BST should be empty");
    }

    @Test
    void testInsertAndSearch() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertTrue(bst.search(50), "Should find root");
        assertTrue(bst.search(30), "Should find left child");
        assertTrue(bst.search(80), "Should find right-most child");
        assertFalse(bst.search(99), "Should not find non-existent value");
        assertFalse(bst.isEmpty(), "BST should not be empty after insertions");
    }

    @Test
    void testTraversals() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        List<Integer> inOrder = bst.inOrderTraversal();
        assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), inOrder, "In-order traversal is incorrect");

        List<Integer> preOrder = bst.preOrderTraversal();
        assertEquals(Arrays.asList(50, 30, 20, 40, 70, 60, 80), preOrder, "Pre-order traversal is incorrect");

        List<Integer> postOrder = bst.postOrderTraversal();
        assertEquals(Arrays.asList(20, 40, 30, 60, 80, 70, 50), postOrder, "Post-order traversal is incorrect");
    }

    @Test
    void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.delete(70);
        assertFalse(bst.search(70), "Deleted leaf node should not be found");
        assertEquals(Arrays.asList(30, 50), bst.inOrderTraversal(), "In-order should be correct after deleting leaf");
    }

    @Test
    void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        bst.delete(70);
        assertFalse(bst.search(70), "Deleted node with one child should not be found");
        assertTrue(bst.search(60), "Child of deleted node should be present");
        assertEquals(Arrays.asList(30, 50, 60), bst.inOrderTraversal(), "In-order should be correct after deleting node with one child");
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.delete(70);
        assertFalse(bst.search(70), "Deleted node with two children should not be found");
        assertTrue(bst.search(80) || bst.search(60), "Successor or predecessor should replace the deleted node");
        assertEquals(Arrays.asList(30, 50, 60, 80), bst.inOrderTraversal(), "In-order should be correct after deleting node with two children");
    }

    @Test
    void testDeleteRoot() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.delete(50);
        assertFalse(bst.search(50), "Deleted root should not be found");
        assertEquals(Arrays.asList(30, 70), bst.inOrderTraversal(), "In-order should be correct after deleting root");
    }
}
