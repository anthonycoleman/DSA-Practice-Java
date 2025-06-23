package com.dsa.datastructures;

/**
 * Generic Stack implementation using dynamic array
 * @param <T> the type of elements stored in this stack
 */
public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int top;
    
    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
        top = -1;
    }
    
    /**
     * Add element to top of stack
     * @param item element to push
     */
    public void push(T item) {
        if (top == elements.length - 1) {
            resize();
        }
        elements[++top] = item;
    }
    
    /**
     * Remove and return top element
     * @return the top element
     * @throws RuntimeException if stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = (T) elements[top];
        elements[top--] = null; // Help GC
        return item;
    }
    
    /**
     * Return top element without removing
     * @return the top element
     * @throws RuntimeException if stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (T) elements[top];
    }
    
    /**
     * Check if stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
     * Get number of elements in stack
     * @return the number of elements
     */
    public int size() {
        return top + 1;
    }
    
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}