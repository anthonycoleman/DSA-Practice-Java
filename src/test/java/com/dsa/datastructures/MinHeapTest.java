package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {
    
    private MinHeap<Integer> heap;
    
    @BeforeEach
    void setUp() {
        heap = new MinHeap<>();
    }
    
    @Test
    void testNewHeap_IsEmpty() {
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
    
    @Test
    void testInsert_SingleElement_SizeIncreases() {
        heap.insert(5);
        
        assertEquals(1, heap.size());
        assertFalse(heap.isEmpty());
        assertEquals(5, heap.peek());
    }
    
    @Test
    void testInsert_MultipleElements_MaintainsMinProperty() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(3);
        heap.insert(8);
        
        assertEquals(5, heap.size());
        assertEquals(3, heap.peek()); // Minimum should be at top
    }
    
    @Test
    void testPeek_EmptyHeap_ThrowsException() {
        assertThrows(RuntimeException.class, () -> heap.peek());
    }
    
    @Test
    void testExtractMin_SingleElement_ReturnsElementAndEmptiesHeap() {
        heap.insert(42);
        
        assertEquals(42, heap.extractMin());
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
    
    @Test
    void testExtractMin_MultipleElements_ReturnsInSortedOrder() {
        int[] values = {10, 5, 15, 3, 8, 12, 1};
        for (int value : values) {
            heap.insert(value);
        }
        
        int[] expected = {1, 3, 5, 8, 10, 12, 15};
        for (int expectedValue : expected) {
            assertEquals(expectedValue, heap.extractMin());
        }
        
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testExtractMin_EmptyHeap_ThrowsException() {
        assertThrows(RuntimeException.class, () -> heap.extractMin());
    }
    
    @Test
    void testHeapProperty_AfterMultipleInsertions() {
        heap.insert(20);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(15);
        heap.insert(25);
        heap.insert(35);
        
        // Root should always be minimum
        assertEquals(5, heap.peek());
        
        // Extract minimum and check next minimum
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.peek());
        
        assertEquals(10, heap.extractMin());
        assertEquals(15, heap.peek());
    }
    
    @Test
    void testMixedOperations_MaintainsHeapProperty() {
        heap.insert(10);
        heap.insert(5);
        assertEquals(5, heap.peek());
        
        heap.insert(3);
        assertEquals(3, heap.peek());
        
        assertEquals(3, heap.extractMin());
        assertEquals(5, heap.peek());
        
        heap.insert(1);
        assertEquals(1, heap.peek());
        
        heap.insert(7);
        assertEquals(1, heap.peek());
    }
    
    @Test
    void testInsertDuplicates_HandlesCorrectly() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(5);
        heap.insert(3);
        heap.insert(1);
        
        assertEquals(5, heap.size());
        assertEquals(1, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(3, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(5, heap.extractMin());
    }
    
    @Test
    void testLargeNumberOfElements_MaintainsPerformance() {
        // Insert many elements in reverse order
        for (int i = 100; i >= 1; i--) {
            heap.insert(i);
        }
        
        assertEquals(100, heap.size());
        assertEquals(1, heap.peek());
        
        // Extract all elements - should come out in sorted order
        for (int i = 1; i <= 100; i++) {
            assertEquals(i, heap.extractMin());
        }
        
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testGenericType_WorksWithStrings() {
        MinHeap<String> stringHeap = new MinHeap<>();
        
        stringHeap.insert("dog");
        stringHeap.insert("cat");
        stringHeap.insert("elephant");
        stringHeap.insert("bird");
        stringHeap.insert("ant");
        
        assertEquals("ant", stringHeap.extractMin());
        assertEquals("bird", stringHeap.extractMin());
        assertEquals("cat", stringHeap.extractMin());
        assertEquals("dog", stringHeap.extractMin());
        assertEquals("elephant", stringHeap.extractMin());
    }
    
    @Test
    void testRandomInsertionOrder_ProducesSortedOutput() {
        int[] randomOrder = {50, 25, 75, 10, 30, 60, 80, 5, 15, 20};
        
        for (int value : randomOrder) {
            heap.insert(value);
        }
        
        int previous = heap.extractMin();
        while (!heap.isEmpty()) {
            int current = heap.extractMin();
            assertTrue(previous <= current, "Heap property violated: " + previous + " > " + current);
            previous = current;
        }
    }
    
    @Test
    void testSingleElementOperations_WorkCorrectly() {
        heap.insert(42);
        assertEquals(42, heap.peek());
        assertEquals(1, heap.size());
        
        assertEquals(42, heap.extractMin());
        assertTrue(heap.isEmpty());
        
        // Insert again after extraction
        heap.insert(99);
        assertEquals(99, heap.peek());
        assertEquals(1, heap.size());
    }
    
    @Test
    void testAlternatingInsertExtract_MaintainsCorrectness() {
        heap.insert(10);
        heap.insert(5);
        assertEquals(5, heap.extractMin());
        
        heap.insert(15);
        heap.insert(3);
        assertEquals(3, heap.extractMin());
        
        heap.insert(20);
        heap.insert(8);
        assertEquals(8, heap.extractMin());
        
        assertEquals(10, heap.extractMin());
        assertEquals(15, heap.extractMin());
        assertEquals(20, heap.extractMin());
        
        assertTrue(heap.isEmpty());
    }
    
    @Test
    void testStressTest_LargeHeap() {
        // Insert 1000 random-ish elements
        for (int i = 0; i < 1000; i++) {
            heap.insert((i * 7 + 13) % 997); // Pseudo-random sequence
        }
        
        assertEquals(1000, heap.size());
        
        // Extract all and verify sorted order
        int previous = heap.extractMin();
        int count = 1;
        
        while (!heap.isEmpty()) {
            int current = heap.extractMin();
            assertTrue(previous <= current);
            previous = current;
            count++;
        }
        
        assertEquals(1000, count);
    }
}