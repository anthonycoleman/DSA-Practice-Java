package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Stack data structure
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "StackTest"
 * ./gradlew test --tests "com.dsa.datastructures.StackTest"
 * ./gradlew test --tests "*Stack*"
 */
class StackTest {
    
    private Stack<Integer> stack;
    
    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }
    
    @Test
    void testNewStack_IsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }
    
    @Test
    void testPush_SingleElement_SizeIncreases() {
        stack.push(1);
        
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }
    
    @Test
    void testPush_MultipleElements_SizeIncreases() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
    }
    
    @Test
    void testPeek_SingleElement_ReturnsElement() {
        stack.push(42);
        
        assertEquals(42, stack.peek());
        assertEquals(1, stack.size()); // Size should not change
    }
    
    @Test
    void testPeek_MultipleElements_ReturnsTopElement() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(3, stack.peek());
        assertEquals(3, stack.size());
    }
    
    @Test
    void testPeek_EmptyStack_ThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.peek());
    }
    
    @Test
    void testPop_SingleElement_ReturnsElementAndDecreasesSize() {
        stack.push(42);
        
        assertEquals(42, stack.pop());
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void testPop_MultipleElements_ReturnsInLIFOOrder() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void testPop_EmptyStack_ThrowsException() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }
    
    @Test
    void testLIFOBehavior_PushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertEquals(30, stack.pop());
        assertEquals(20, stack.peek());
        
        stack.push(40);
        assertEquals(40, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }
    
    @Test
    void testMixedOperations_WorkCorrectly() {
        assertTrue(stack.isEmpty());
        
        stack.push(1);
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.peek());
        
        stack.push(2);
        assertEquals(2, stack.size());
        
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
        
        stack.push(3);
        assertEquals(3, stack.peek());
        assertEquals(2, stack.size());
    }
    
    @Test
    void testDynamicResizing_HandlesLargeNumberOfElements() {
        // Test that stack can handle more elements than initial capacity
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        
        assertEquals(100, stack.size());
        
        // Pop all elements and verify they come out in reverse order
        for (int i = 99; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void testGenericType_WorksWithStrings() {
        Stack<String> stringStack = new Stack<>();
        
        stringStack.push("first");
        stringStack.push("second");
        stringStack.push("third");
        
        assertEquals("third", stringStack.pop());
        assertEquals("second", stringStack.pop());
        assertEquals("first", stringStack.pop());
        assertTrue(stringStack.isEmpty());
    }
    
    @Test
    void testGenericType_WorksWithNullValues() {
        Stack<String> stringStack = new Stack<>();
        
        stringStack.push("not null");
        stringStack.push(null);
        stringStack.push("also not null");
        
        assertEquals("also not null", stringStack.pop());
        assertNull(stringStack.pop());
        assertEquals("not null", stringStack.pop());
    }
    
    @Test
    void testPopAfterPushMany_MaintainsOrder() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i * 10);
        }
        
        assertEquals(50, stack.pop());
        assertEquals(40, stack.pop());
        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void testStackWithMaxIntegerValues_HandlesCorrectly() {
        stack.push(Integer.MAX_VALUE);
        stack.push(Integer.MIN_VALUE);
        stack.push(0);
        
        assertEquals(0, stack.pop());
        assertEquals(Integer.MIN_VALUE, stack.pop());
        assertEquals(Integer.MAX_VALUE, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    void testStackAfterManyResizes_WorksCorrectly() {
        // Force multiple resizes
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        
        assertEquals(1000, stack.size());
        assertEquals(999, stack.peek());
        
        // Pop half
        for (int i = 999; i >= 500; i--) {
            assertEquals(i, stack.pop());
        }
        
        assertEquals(500, stack.size());
        assertEquals(499, stack.peek());
    }
    
    @Test
    void testAlternatingPushPop_StressTest() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
            if (i % 3 == 0 && !stack.isEmpty()) {
                stack.pop();
            }
        }
        
        // Stack should not be empty
        assertFalse(stack.isEmpty());
        assertTrue(stack.size() > 0);
        
        // Clear the stack
        while (!stack.isEmpty()) {
            stack.pop();
        }
        
        assertTrue(stack.isEmpty());
    }
}