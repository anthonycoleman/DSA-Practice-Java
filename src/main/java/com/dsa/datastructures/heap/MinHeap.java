package com.dsa.datastructures.heap;

import java.util.List;

/**
 * An implementation of a Min-Heap, a binary tree-based data structure
 * that satisfies the min-heap property: the value of each node is less than or
 * equal to the value of its children.
 * @param <T> the type of elements held in this collection, must be comparable
 */
public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MinHeap() {
        // TODO: Initialize the heap's internal storage (e.g., an ArrayList)
    }

    /**
     * Adds a new element to the heap, maintaining the heap property.
     * @param item The element to add.
     */
    public void insert(T item) {
        // TODO: Implement insert. Add the element to the end and heapify up.
    }

    /**
     * Retrieves, but does not remove, the minimum element of this heap.
     * @return The minimum element.
     * @throws IllegalStateException if the heap is empty.
     */
    public T peek() {
        // TODO: Implement peek. The min element is always at the root.
        return null;
    }

    /**
     * Retrieves and removes the minimum element of this heap.
     * @return The minimum element.
     * @throws IllegalStateException if the heap is empty.
     */
    public T extractMin() {
        // TODO: Implement extractMin. Replace root with last element, then heapify down.
        return null;
    }

    /**
     * Returns the number of elements in this heap.
     * @return The number of elements.
     */
    public int size() {
        // TODO: Implement size.
        return 0;
    }

    /**
     * Returns true if this heap contains no elements.
     * @return true if this heap is empty.
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty.
        return true;
    }
}
