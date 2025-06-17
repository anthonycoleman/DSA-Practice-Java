package com.dsa.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;

public class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testNewQueueIsEmpty() {
        assertTrue(queue.isEmpty(), "A new queue should be empty");
        assertEquals(0, queue.size(), "A new queue should have size 0");
    }

    @Test
    void testEnqueueAndPeek() {
        queue.enqueue("first");
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        assertEquals(1, queue.size(), "Queue size should be 1 after one enqueue");
        assertEquals("first", queue.peek(), "Peek should return the first enqueued item");

        queue.enqueue("second");
        assertEquals(2, queue.size(), "Queue size should be 2 after two enqueues");
        assertEquals("first", queue.peek(), "Peek should still return the first item");
    }

    @Test
    void testEnqueueAndDequeue() {
        queue.enqueue("first");
        queue.enqueue("second");
        assertEquals("first", queue.dequeue(), "Dequeue should return the first enqueued item");
        assertEquals(1, queue.size(), "Queue size should be 1 after dequeue");
        assertEquals("second", queue.dequeue(), "Dequeue should return the second item");
        assertEquals(0, queue.size(), "Queue size should be 0 after all items are dequeued");
        assertTrue(queue.isEmpty(), "Queue should be empty after all items are dequeued");
    }

    @Test
    void testDequeueOnEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        }, "Dequeue on an empty queue should throw NoSuchElementException");
    }

    @Test
    void testPeekOnEmptyQueueThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            queue.peek();
        }, "Peek on an empty queue should throw NoSuchElementException");
    }

    @Test
    void testComplexScenario() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals("A", queue.dequeue());
        queue.enqueue("C");
        assertEquals("B", queue.peek());
        assertEquals(2, queue.size());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
