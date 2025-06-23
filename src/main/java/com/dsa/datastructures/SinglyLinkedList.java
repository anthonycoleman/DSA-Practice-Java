package com.dsa.datastructures;

/**
 * Generic Singly Linked List implementation
 * @param <T> the type of elements stored in this list
 */
public class SinglyLinkedList<T> {
    
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> head;
    private int size;
    
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * Add element to beginning of list
     * @param data element to add
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Add element to end of list
     * @param data element to add
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
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
     * Remove and return first element
     * @return the first element
     * @throws RuntimeException if list is empty
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    /**
     * Remove and return last element
     * @return the last element
     * @throws RuntimeException if list is empty
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    /**
     * Get element at specified index
     * @param index the index to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
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
     * Check if list contains specified element
     * @param data element to search for
     * @return true if element is found, false otherwise
     */
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if ((current.data == null && data == null) || 
                (current.data != null && current.data.equals(data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Get number of elements in list
     * @return the number of elements
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if list is empty
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}