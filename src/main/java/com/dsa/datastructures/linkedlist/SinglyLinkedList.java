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
        this.head = null;
        this.size = 0;
    }

    /**
     * Adds an element to the beginning of the list.
     * @param data the data to add
     */
    public void addFirst(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list.");
        }
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     * @param data the data to add
     */
    public void addLast(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null data to the list.");
        }
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the first element from the list.
     * @return the data of the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Removes and returns the last element from the list.
     * @return the data of the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) { // or head.next == null
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        T data = current.data;
        if (previous != null) {
            previous.next = null;
        }
        size--;
        return data;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Returns true if this list contains the specified element.
     * @param data element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(T data) {
        if (data == null) return false; // Or throw IllegalArgumentException depending on desired behavior
        Node<T> current = head;
        while (current != null) {
            if (data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
