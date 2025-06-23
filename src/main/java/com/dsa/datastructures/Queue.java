package com.dsa.datastructures;

/**
 * Generic Queue implementation using circular array
 * @param <T> the type of elements stored in this queue
 */
public class Queue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int front;
    private int rear;
    private int size;
    
    public Queue() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    /**
     * Add element to rear of queue
     * @param item element to enqueue
     */
    public void enqueue(T item) {
        if (size == elements.length) {
            resize();
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = item;
        size++;
    }
    
    /**
     * Remove and return front element
     * @return the front element
     * @throws RuntimeException if queue is empty
     */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T item = (T) elements[front];
        elements[front] = null; // Help GC
        front = (front + 1) % elements.length;
        size--;
        return item;
    }
    
    /**
     * Return front element without removing
     * @return the front element
     * @throws RuntimeException if queue is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return (T) elements[front];
    }
    
    /**
     * Check if queue is empty
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Get number of elements in queue
     * @return the number of elements
     */
    public int size() {
        return size;
    }
    
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(front + i) % elements.length];
        }
        elements = newElements;
        front = 0;
        rear = size - 1;
    }
}