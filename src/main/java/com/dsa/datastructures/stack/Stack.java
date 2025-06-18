package com.dsa.datastructures.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * A last-in-first-out (LIFO) stack of objects.
 * @param <T> the type of elements in this stack
 */
public class Stack<T> {

    private ArrayList<T> storage;

    public Stack() {
        storage = new ArrayList<>();
    }

    /**
     * Pushes an item onto the top of this stack.
     * @param item the item to be pushed onto this stack.
     */
    public void push(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot push null onto the stack.");
        }
        storage.add(item);
    }

    /**
     * Removes the object at the top of this stack and returns that object.
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return storage.remove(storage.size() - 1);
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return storage.get(storage.size() - 1);
    }

    /**
     * Tests if this stack is empty.
     * @return true if and only if this stack contains no items; false otherwise.
     */
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     * @return the number of items in this stack.
     */
    public int size() {
        return storage.size();
    }
}
