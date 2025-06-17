package com.dsa.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void testNewListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddFirst() {
        list.addFirst(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        list.addFirst(20);
        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void testAddLast() {
        list.addLast(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));

        list.addLast(20);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testRemoveFirst() {
        list.addLast(10);
        list.addLast(20);
        assertEquals(10, list.removeFirst());
        assertEquals(1, list.size());
        assertEquals(20, list.get(0));
    }

    @Test
    void testRemoveLast() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(30, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(20, list.get(1));
    }

    @Test
    void testGet() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(20, list.get(1));
    }

    @Test
    void testContains() {
        list.addLast(10);
        list.addLast(20);
        assertTrue(list.contains(20));
        assertFalse(list.contains(30));
    }

    @Test
    void testExceptions() {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
        assertThrows(NoSuchElementException.class, () -> list.removeLast());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testComplexScenario() {
        list.addFirst(1);
        list.addLast(3);
        list.addFirst(0);
        list.addLast(4); // 0 -> 1 -> 3 -> 4
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(4, list.get(3));
        assertEquals(0, list.removeFirst()); // 1 -> 3 -> 4
        assertEquals(4, list.removeLast()); // 1 -> 3
        assertFalse(list.contains(4));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
    }
}
