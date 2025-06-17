package com.dsa.datastructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * A singly linked list implementation.
 * @param <T> the type of elements held in this collection
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        // TODO: Initialize the linked list
    }

    /**
     * Adds an element to the beginning of the list.
     * @param data the data to add
     */
    public void addFirst(T data) {
        // TODO: Implement addFirst
    }

    /**
     * Adds an element to the end of the list.
     * @param data the data to add
     */
    public void addLast(T data) {
        // TODO: Implement addLast
    }

    /**
     * Removes and returns the first element from the list.
     * @return the data of the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        // TODO: Implement removeFirst
        return null;
    }

    /**
     * Removes and returns the last element from the list.
     * @return the data of the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() {
        // TODO: Implement removeLast
        return null;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        // TODO: Implement get
        return null;
    }

    /**
     * Returns true if this list contains the specified element.
     * @param data element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(T data) {
        // TODO: Implement contains
        return false;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements
     */
    public int size() {
        // TODO: Implement size
        return 0;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list is empty
     */
    public boolean isEmpty() {
        // TODO: Implement isEmpty
        return true;
    }
}
