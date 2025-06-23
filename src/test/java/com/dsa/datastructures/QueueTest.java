package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Queue data structure
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "QueueTest"
 * ./gradlew test --tests "com.dsa.datastructures.QueueTest"
 * ./gradlew test --tests "*Queue*"
 */
class QueueTest {
    
    private Queue<Integer> queue;
    
    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }
    
    @Test
    void testNewQueue_IsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }
    
    @Test
    void testEnqueue_SingleElement_SizeIncreases() {
        queue.enqueue(1);
        
        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
    }
    
    @Test
    void testEnqueue_MultipleElements_SizeIncreases() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
    }
    
    @Test
    void testPeek_SingleElement_ReturnsElement() {
        queue.enqueue(42);
        
        assertEquals(42, queue.peek());
        assertEquals(1, queue.size()); // Size should not change
    }
    
    @Test
    void testPeek_MultipleElements_ReturnsFrontElement() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(1, queue.peek()); // First element added
        assertEquals(3, queue.size());
    }
    
    @Test
    void testPeek_EmptyQueue_ThrowsException() {
        assertThrows(RuntimeException.class, () -> queue.peek());
    }
    
    @Test
    void testDequeue_SingleElement_ReturnsElementAndDecreasesSize() {
        queue.enqueue(42);
        
        assertEquals(42, queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testDequeue_MultipleElements_ReturnsInFIFOOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testDequeue_EmptyQueue_ThrowsException() {
        assertThrows(RuntimeException.class, () -> queue.dequeue());
    }
    
    @Test
    void testFIFOBehavior_EnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.peek());
        
        queue.enqueue(40);
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
    }
    
    @Test
    void testMixedOperations_WorkCorrectly() {
        assertTrue(queue.isEmpty());
        
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.peek());
        
        queue.enqueue(2);
        assertEquals(2, queue.size());
        
        assertEquals(1, queue.dequeue());
        assertEquals(1, queue.size());
        
        queue.enqueue(3);
        assertEquals(2, queue.peek());
        assertEquals(2, queue.size());
    }
    
    @Test
    void testCircularBehavior_HandlesWraparound() {
        // Fill queue to initial capacity and beyond
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }
        
        // Remove some elements
        for (int i = 0; i < 5; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        // Add more elements (should wrap around)
        for (int i = 15; i < 20; i++) {
            queue.enqueue(i);
        }
        
        // Verify correct order
        for (int i = 5; i < 20; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testDynamicResizing_HandlesLargeNumberOfElements() {
        // Test that queue can handle more elements than initial capacity
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        
        assertEquals(100, queue.size());
        
        // Dequeue all elements and verify they come out in correct order
        for (int i = 0; i < 100; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testGenericType_WorksWithStrings() {
        Queue<String> stringQueue = new Queue<>();
        
        stringQueue.enqueue("first");
        stringQueue.enqueue("second");
        stringQueue.enqueue("third");
        
        assertEquals("first", stringQueue.dequeue());
        assertEquals("second", stringQueue.dequeue());
        assertEquals("third", stringQueue.dequeue());
        assertTrue(stringQueue.isEmpty());
    }
    
    @Test
    void testGenericType_WorksWithNullValues() {
        Queue<String> stringQueue = new Queue<>();
        
        stringQueue.enqueue("not null");
        stringQueue.enqueue(null);
        stringQueue.enqueue("also not null");
        
        assertEquals("not null", stringQueue.dequeue());
        assertNull(stringQueue.dequeue());
        assertEquals("also not null", stringQueue.dequeue());
    }
    
    @Test
    void testAlternatingOperations_MaintainsCorrectOrder() {
        queue.enqueue(1);
        queue.enqueue(2);
        
        assertEquals(1, queue.dequeue());
        
        queue.enqueue(3);
        queue.enqueue(4);
        
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        
        queue.enqueue(5);
        
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        
        assertTrue(queue.isEmpty());
    }
    
    @Test
    void testResizeAfterManyOperations_WorksCorrectly() {
        // Perform many enqueue/dequeue operations to test resizing
        for (int i = 0; i < 50; i++) {
            queue.enqueue(i);
        }
        
        for (int i = 0; i < 25; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        for (int i = 50; i < 75; i++) {
            queue.enqueue(i);
        }
        
        // Verify remaining elements are in correct order
        for (int i = 25; i < 75; i++) {
            assertEquals(i, queue.dequeue());
        }
        
        assertTrue(queue.isEmpty());
    }
}