package com.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Binary Search Tree implementation
 * @param <T> the type of elements stored in this tree, must be comparable
 */
public class BinarySearchTree<T extends Comparable<T>> {
    
    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        
        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node<T> root;
    
    public BinarySearchTree() {
        root = null;
    }
    
    /**
     * Insert value into BST
     * @param value value to insert
     */
    public void insert(T value) {
        root = insertHelper(root, value);
    }
    
    private Node<T> insertHelper(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        
        int comparison = value.compareTo(node.data);
        if (comparison < 0) {
            node.left = insertHelper(node.left, value);
        } else if (comparison > 0) {
            node.right = insertHelper(node.right, value);
        }
        // If equal, don't insert (no duplicates)
        
        return node;
    }
    
    /**
     * Search for value in BST
     * @param value value to search for
     * @return true if found, false otherwise
     */
    public boolean search(T value) {
        return searchHelper(root, value);
    }
    
    private boolean searchHelper(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        
        int comparison = value.compareTo(node.data);
        if (comparison == 0) {
            return true;
        } else if (comparison < 0) {
            return searchHelper(node.left, value);
        } else {
            return searchHelper(node.right, value);
        }
    }
    
    /**
     * Delete value from BST
     * @param value value to delete
     */
    public void delete(T value) {
        root = deleteHelper(root, value);
    }
    
    private Node<T> deleteHelper(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        
        int comparison = value.compareTo(node.data);
        if (comparison < 0) {
            node.left = deleteHelper(node.left, value);
        } else if (comparison > 0) {
            node.right = deleteHelper(node.right, value);
        } else {
            // Node to delete found
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // Node has two children
                T minValue = findMin(node.right);
                node.data = minValue;
                node.right = deleteHelper(node.right, minValue);
            }
        }
        
        return node;
    }
    
    private T findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    
    /**
     * In-order traversal (returns sorted order)
     * @return list of elements in sorted order
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
    
    private void inOrderHelper(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderHelper(node.left, result);
            result.add(node.data);
            inOrderHelper(node.right, result);
        }
    }
    
    /**
     * Pre-order traversal
     * @return list of elements in pre-order
     */
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }
    
    private void preOrderHelper(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data);
            preOrderHelper(node.left, result);
            preOrderHelper(node.right, result);
        }
    }
    
    /**
     * Post-order traversal
     * @return list of elements in post-order
     */
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }
    
    private void postOrderHelper(Node<T> node, List<T> result) {
        if (node != null) {
            postOrderHelper(node.left, result);
            postOrderHelper(node.right, result);
            result.add(node.data);
        }
    }
    
    /**
     * Check if BST is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }
}