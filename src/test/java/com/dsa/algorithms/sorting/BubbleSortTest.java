package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Bubble Sort algorithm
 */
class BubbleSortTest {
    
    @Test
    void testBubbleSort_EmptyArray_NoChange() {
        int[] arr = {};
        BubbleSort.bubbleSort(arr);
        assertEquals(0, arr.length);
    }
    
    @Test
    void testBubbleSort_SingleElement_NoChange() {
        int[] arr = {5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }
    
    @Test
    void testBubbleSort_AlreadySorted_NoChange() {
        int[] arr = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testBubbleSort_ReverseSorted_SortsCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testBubbleSort_RandomOrder_SortsCorrectly() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 6, 9}, arr);
    }
    
    @Test
    void testBubbleSort_NullArray_NoException() {
        assertDoesNotThrow(() -> BubbleSort.bubbleSort(null));
    }
    
    @Test
    void testBubbleSort_WithDuplicates_HandlesCorrectly() {
        int[] arr = {3, 1, 3, 2, 1, 2};
        int[] expected = {1, 1, 2, 2, 3, 3};
        
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testBubbleSort_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-5, 3, -1, 0, 7, -3};
        int[] expected = {-5, -3, -1, 0, 3, 7};
        
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testBubbleSort_AllSameElements_HandlesCorrectly() {
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testBubbleSort_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        
        BubbleSort.bubbleSort(arr);
        
        assertEquals(Integer.MIN_VALUE, arr[0]);
        assertEquals(Integer.MAX_VALUE, arr[4]);
        
        // Verify sorted order
        for (int i = 0; i < 4; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
    
    @Test
    void testBubbleSort_TwoElements_SortsCorrectly() {
        int[] arr = {2, 1};
        BubbleSort.bubbleSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
        
        int[] arr2 = {1, 2};
        BubbleSort.bubbleSort(arr2);
        assertArrayEquals(new int[]{1, 2}, arr2);
    }
}