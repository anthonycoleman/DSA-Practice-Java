package com.dsa.datastructures.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException; // Using this for consistency with other data structures, though stub suggested IllegalStateException

/**
 * An implementation of a Min-Heap, a binary tree-based data structure
 * that satisfies the min-heap property: the value of each node is less than or
 * equal to the value of its children.
 * @param <T> the type of elements held in this collection, must be comparable
 */
public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    /**
     * Adds a new element to the heap, maintaining the heap property.
     * @param item The element to add.
     */
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot insert null item into the heap.");
        }
        heap.add(item);
        siftUp();
    }

    /**
     * Retrieves, but does not remove, the minimum element of this heap.
     * @return The minimum element.
     * @throws IllegalStateException if the heap is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty."); // Changed to NoSuchElementException for consistency
        }
        return heap.get(0);
    }

    /**
     * Retrieves and removes the minimum element of this heap.
     * @return The minimum element.
     * @throws IllegalStateException if the heap is empty.
     */
    public T extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty."); // Changed to NoSuchElementException for consistency
        }
        T minItem = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, lastItem);
            siftDown();
        }
        return minItem;
    }

    /**
     * Returns the number of elements in this heap.
     * @return The number of elements.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Returns true if this heap contains no elements.
     * @return true if this heap is empty.
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Helper methods
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    private boolean hasLeftChild(int parentIndex) {
        return getLeftChildIndex(parentIndex) < heap.size();
    }

    private boolean hasRightChild(int parentIndex) {
        return getRightChildIndex(parentIndex) < heap.size();
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = heap.get(indexOne);
        heap.set(indexOne, heap.get(indexTwo));
        heap.set(indexTwo, temp);
    }

    private void siftUp() {
        int index = heap.size() - 1;
        while (hasParent(index) && heap.get(index).compareTo(heap.get(getParentIndex(index))) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void siftDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && heap.get(getRightChildIndex(index)).compareTo(heap.get(smallerChildIndex)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap.get(index).compareTo(heap.get(smallerChildIndex)) < 0) {
                break; // Heap property is satisfied
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
}
