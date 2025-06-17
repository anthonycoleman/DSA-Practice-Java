package com.dsa.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;

public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty(), "A new stack should be empty");
        assertEquals(0, stack.size(), "A new stack should have size 0");
    }

    @Test
    void testPushAndPeek() {
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.size(), "Stack size should be 1 after one push");
        assertEquals(10, stack.peek(), "Peek should return the last pushed item");

        stack.push(20);
        assertEquals(2, stack.size(), "Stack size should be 2 after two pushes");
        assertEquals(20, stack.peek(), "Peek should return the new last pushed item");
    }

    @Test
    void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop(), "Pop should return the last pushed item");
        assertEquals(1, stack.size(), "Stack size should be 1 after pop");
        assertEquals(10, stack.pop(), "Pop should return the remaining item");
        assertEquals(0, stack.size(), "Stack size should be 0 after all items are popped");
        assertTrue(stack.isEmpty(), "Stack should be empty after all items are popped");
    }

    @Test
    void testPopOnEmptyStackThrowsException() {
        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        }, "Pop on an empty stack should throw EmptyStackException");
    }

    @Test
    void testPeekOnEmptyStackThrowsException() {
        assertThrows(EmptyStackException.class, () -> {
            stack.peek();
        }, "Peek on an empty stack should throw EmptyStackException");
    }

    @Test
    void testComplexScenario() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(2, stack.size());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
}
