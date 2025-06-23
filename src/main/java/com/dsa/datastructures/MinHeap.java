package com.dsa.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic Min-Heap implementation using array-based approach
 * @param <T> the type of elements stored in this heap, must be comparable
 */
public class MinHeap<T extends Comparable<T>> {
    private final List<T> heap;
    
    public MinHeap() {
        heap = new ArrayList<>();
    }
    
    /**
     * Insert item into heap
     * @param item item to insert
     */
    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }
    
    /**
     * Get minimum element without removing
     * @return the minimum element
     * @throws RuntimeException if heap is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }
    
    /**
     * Remove and return minimum element
     * @return the minimum element
     * @throws RuntimeException if heap is empty
     */
    public T extractMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        
        T min = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);
        
        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        
        return min;
    }
    
    /**
     * Get number of elements in heap
     * @return the number of elements
     */
    public int size() {
        return heap.size();
    }
    
    /**
     * Check if heap is empty
     * @return true if heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    private void heapifyUp(int index) {
        if (index == 0) return;
        
        int parentIndex = getParentIndex(index);
        if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }
    
    private void heapifyDown(int index) {
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);
        int smallest = index;
        
        if (leftChild < heap.size() && 
            heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }
        
        if (rightChild < heap.size() && 
            heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }
        
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    
    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
    
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }
    
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
    
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}