package com.dsa.datastructures.tree;

import java.util.List;

/**
 * A binary search tree (BST) implementation.
 * @param <T> the type of elements held in this collection, must be comparable
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinarySearchTree() {
        // TODO: Initialize the BST
    }

    /**
     * Inserts a new value into the BST.
     * @param data the value to insert
     */
    public void insert(T data) {
        // TODO: Implement insert
    }

    /**
     * Searches for a value in the BST.
     * @param data the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean search(T data) {
        // TODO: Implement search
        return false;
    }

    /**
     * Deletes a value from the BST.
     * @param data the value to delete
     */
    public void delete(T data) {
        // TODO: Implement delete
    }

    /**
     * Performs an in-order traversal of the BST.
     * @return a list of elements in in-order
     */
    public List<T> inOrderTraversal() {
        // TODO: Implement in-order traversal
        return null;
    }

    /**
     * Performs a pre-order traversal of the BST.
     * @return a list of elements in pre-order
     */
    public List<T> preOrderTraversal() {
        // TODO: Implement pre-order traversal
        return null;
    }

    /**
     * Performs a post-order traversal of the BST.
     * @return a list of elements in post-order
     */
    public List<T> postOrderTraversal() {
        // TODO: Implement post-order traversal
        return null;
    }
    
    /**
     * Returns true if this tree contains no elements.
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty
        return true;
    }
}
