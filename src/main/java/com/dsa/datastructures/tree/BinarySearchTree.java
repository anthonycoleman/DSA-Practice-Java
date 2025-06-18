package com.dsa.datastructures.tree;

import java.util.ArrayList;
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
        this.root = null;
    }

    /**
     * Inserts a new value into the BST.
     * @param data the value to insert
     */
    public void insert(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot insert null data into the BST.");
        }
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            current.left = insertRec(current.left, data);
        } else if (cmp > 0) {
            current.right = insertRec(current.right, data);
        } else {
            // Value already exists, do nothing or handle as per requirements (e.g., update)
            return current;
        }
        return current;
    }

    /**
     * Searches for a value in the BST.
     * @param data the value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean search(T data) {
        if (data == null) return false;
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> current, T data) {
        if (current == null) {
            return false;
        }
        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            return searchRec(current.left, data);
        } else if (cmp > 0) {
            return searchRec(current.right, data);
        } else {
            // Value found
            return true;
        }
    }

    /**
     * Deletes a value from the BST.
     * @param data the value to delete
     */
    public void delete(T data) {
        if (data == null) return; // Or throw exception
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> current, T data) {
        if (current == null) {
            return null; // Value not found
        }

        int cmp = data.compareTo(current.data);
        if (cmp < 0) {
            current.left = deleteRec(current.left, data);
        } else if (cmp > 0) {
            current.right = deleteRec(current.right, data);
        } else {
            // Node to be deleted found
            // Case 1: Node with only one child or no child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            current.data = minValue(current.right);

            // Delete the inorder successor
            current.right = deleteRec(current.right, current.data);
        }
        return current;
    }

    private T minValue(Node<T> node) {
        T minval = node.data;
        while (node.left != null) {
            minval = node.left.data;
            node = node.left;
        }
        return minval;
    }

    /**
     * Performs an in-order traversal of the BST.
     * @return a list of elements in in-order
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.data);
            inOrderRec(node.right, result);
        }
    }

    /**
     * Performs a pre-order traversal of the BST.
     * @return a list of elements in pre-order
     */
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data);
            preOrderRec(node.left, result);
            preOrderRec(node.right, result);
        }
    }

    /**
     * Performs a post-order traversal of the BST.
     * @return a list of elements in post-order
     */
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node<T> node, List<T> result) {
        if (node != null) {
            postOrderRec(node.left, result);
            postOrderRec(node.right, result);
            result.add(node.data);
        }
    }
    
    /**
     * Returns true if this tree contains no elements.
     * @return true if this tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }
}
