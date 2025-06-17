package com.dsa.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    private MinHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test
    void testNewHeapIsEmpty() {
        assertTrue(minHeap.isEmpty());
        assertEquals(0, minHeap.size());
    }

    @Test
    void testInsertAndPeek() {
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
        assertEquals(1, minHeap.size());
        assertEquals(10, minHeap.peek());

        minHeap.insert(5);
        assertEquals(2, minHeap.size());
        assertEquals(5, minHeap.peek());

        minHeap.insert(15);
        assertEquals(3, minHeap.size());
        assertEquals(5, minHeap.peek());
    }

    @Test
    void testExtractMin() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);

        assertEquals(3, minHeap.extractMin());
        assertEquals(3, minHeap.size());
        assertEquals(5, minHeap.peek());

        assertEquals(5, minHeap.extractMin());
        assertEquals(2, minHeap.size());
        assertEquals(10, minHeap.peek());

        assertEquals(10, minHeap.extractMin());
        assertEquals(1, minHeap.size());
        assertEquals(15, minHeap.peek());

        assertEquals(15, minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testExceptionsOnEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> minHeap.peek());
        assertThrows(IllegalStateException.class, () -> minHeap.extractMin());
    }

    @Test
    void testHeapWithDuplicates() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(10);
        assertEquals(3, minHeap.size());
        assertEquals(5, minHeap.extractMin());
        assertEquals(10, minHeap.extractMin());
        assertEquals(10, minHeap.extractMin());
    }
}
