package com.dsa.datastructures.stack;

import java.util.EmptyStackException;

/**
 * A last-in-first-out (LIFO) stack of objects.
 * @param <T> the type of elements in this stack
 */
public class Stack<T> {

    // You can use an ArrayList or a dynamic array for the underlying storage.

    public Stack() {
        // TODO: Initialize the stack's internal storage
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param item the item to be pushed onto this stack.
     */
    public void push(T item) {
        // TODO: Implement push operation
    }

    /**
     * Removes the object at the top of this stack and returns that object.
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public T pop() {
        // TODO: Implement pop operation
        return null;
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public T peek() {
        // TODO: Implement peek operation
        return null;
    }

    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty operation
        return true;
    }

    /**
     * Returns the number of items in this stack.
     * @return the number of items in this stack.
     */
    public int size() {
        // TODO: Implement size operation
        return 0;
    }
}
