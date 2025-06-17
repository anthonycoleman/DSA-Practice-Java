package com.dsa.datastructures.queue;

import java.util.NoSuchElementException;

/**
 * A first-in-first-out (FIFO) queue of objects.
 * @param <T> the type of elements in this queue
 */
public class Queue<T> {

    // You can use a LinkedList or a dynamic array for the underlying storage.

    public Queue() {
        // TODO: Initialize the queue's internal storage
    }

    /**
     * Inserts the specified element into this queue.
     * @param item the element to add
     */
    public void enqueue(T item) {
        // TODO: Implement enqueue operation
    }

    /**
     * Retrieves and removes the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() {
        // TODO: Implement dequeue operation
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() {
        // TODO: Implement peek operation
        return null;
    }

    /**
     * Tests if this queue is empty.
     * @return true if and only if this queue contains no items; false otherwise.
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty operation
        return true;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue.
     */
    public int size() {
        // TODO: Implement size operation
        return 0;
    }
}
