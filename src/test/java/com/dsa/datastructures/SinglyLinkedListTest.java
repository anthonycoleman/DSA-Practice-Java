package com.dsa.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    
    private SinglyLinkedList<Integer> list;
    
    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }
    
    @Test
    void testNewList_IsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testAddFirst_SingleElement_SizeIncreases() {
        list.addFirst(1);
        
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals(1, list.get(0));
    }
    
    @Test
    void testAddFirst_MultipleElements_AddsToBeginning() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        
        assertEquals(3, list.size());
        assertEquals(3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(1, list.get(2));
    }
    
    @Test
    void testAddLast_SingleElement_SizeIncreases() {
        list.addLast(1);
        
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals(1, list.get(0));
    }
    
    @Test
    void testAddLast_MultipleElements_AddsToEnd() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }
    
    @Test
    void testMixedAddOperations_WorkCorrectly() {
        list.addFirst(2);   // [2]
        list.addLast(3);    // [2, 3]
        list.addFirst(1);   // [1, 2, 3]
        list.addLast(4);    // [1, 2, 3, 4]
        
        assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }
    
    @Test
    void testRemoveFirst_SingleElement_ReturnsElementAndEmptiesList() {
        list.addFirst(42);
        
        assertEquals(42, list.removeFirst());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testRemoveFirst_MultipleElements_RemovesFromBeginning() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        assertEquals(1, list.removeFirst());
        assertEquals(2, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
    }
    
    @Test
    void testRemoveFirst_EmptyList_ThrowsException() {
        assertThrows(RuntimeException.class, () -> list.removeFirst());
    }
    
    @Test
    void testRemoveLast_SingleElement_ReturnsElementAndEmptiesList() {
        list.addLast(42);
        
        assertEquals(42, list.removeLast());
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testRemoveLast_MultipleElements_RemovesFromEnd() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        assertEquals(3, list.removeLast());
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }
    
    @Test
    void testRemoveLast_EmptyList_ThrowsException() {
        assertThrows(RuntimeException.class, () -> list.removeLast());
    }
    
    @Test
    void testGet_ValidIndices_ReturnsCorrectElements() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }
    
    @Test
    void testGet_InvalidIndex_ThrowsException() {
        list.addLast(1);
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }
    
    @Test
    void testGet_EmptyList_ThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
    
    @Test
    void testContains_ElementExists_ReturnsTrue() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }
    
    @Test
    void testContains_ElementNotExists_ReturnsFalse() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        assertFalse(list.contains(0));
        assertFalse(list.contains(4));
        assertFalse(list.contains(10));
    }
    
    @Test
    void testContains_EmptyList_ReturnsFalse() {
        assertFalse(list.contains(1));
    }
    
    @Test
    void testContains_WithNullValues_WorksCorrectly() {
        SinglyLinkedList<String> stringList = new SinglyLinkedList<>();
        stringList.addLast("first");
        stringList.addLast(null);
        stringList.addLast("third");
        
        assertTrue(stringList.contains("first"));
        assertTrue(stringList.contains(null));
        assertTrue(stringList.contains("third"));
        assertFalse(stringList.contains("fourth"));
    }
    
    @Test
    void testSequentialOperations_WorkCorrectly() {
        // Add elements
        for (int i = 1; i <= 5; i++) {
            list.addLast(i);
        }
        
        assertEquals(5, list.size());
        
        // Remove from both ends
        assertEquals(1, list.removeFirst());
        assertEquals(5, list.removeLast());
        
        assertEquals(3, list.size());
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }
    
    @Test
    void testGenericType_WorksWithStrings() {
        SinglyLinkedList<String> stringList = new SinglyLinkedList<>();
        
        stringList.addLast("first");
        stringList.addLast("second");
        stringList.addFirst("zero");
        
        assertEquals(3, stringList.size());
        assertEquals("zero", stringList.get(0));
        assertEquals("first", stringList.get(1));
        assertEquals("second", stringList.get(2));
        
        assertEquals("zero", stringList.removeFirst());
        assertEquals("second", stringList.removeLast());
        assertEquals("first", stringList.get(0));
    }
    
    @Test
    void testLargeNumberOfElements_HandlesCorrectly() {
        // Add many elements
        for (int i = 0; i < 1000; i++) {
            list.addLast(i);
        }
        
        assertEquals(1000, list.size());
        
        // Verify random access
        assertEquals(0, list.get(0));
        assertEquals(500, list.get(500));
        assertEquals(999, list.get(999));
        
        // Remove elements and verify
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, list.removeFirst());
        }
        
        assertTrue(list.isEmpty());
    }
    
    @Test
    void testRemoveAllElements_LeaveEmptyList() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
    
    @Test
    void testAlternatingAddRemove_MaintainsCorrectState() {
        list.addFirst(1);
        assertEquals(1, list.removeFirst());
        assertTrue(list.isEmpty());
        
        list.addLast(2);
        list.addLast(3);
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeLast());
        assertTrue(list.isEmpty());
        
        list.addFirst(4);
        list.addFirst(5);
        assertEquals(4, list.removeLast());
        assertEquals(5, list.removeFirst());
        assertTrue(list.isEmpty());
    }
}