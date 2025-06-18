package com.dsa.datastructures.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * A first-in-first-out (FIFO) queue of objects.
 * @param <T> the type of elements in this queue
 */
public class Queue<T> {

    private LinkedList<T> storage;

    public Queue() {
        storage = new LinkedList<>();
    }

    /**
     * Inserts the specified element into this queue.
     * @param item the element to add
     */
    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item.");
        }
        storage.addLast(item);
    }

    /**
     * Retrieves and removes the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return storage.removeFirst();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return storage.peekFirst();
    }

    /**
     * Tests if this queue is empty.
     * @return true if and only if this queue contains no items; false otherwise.
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue.
     */
    public int size() {
        return storage.size();
    }
}
