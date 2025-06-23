package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Quick Sort algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "QuickSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.QuickSortTest"
 * ./gradlew test --tests "*QuickSort*"
 */
class QuickSortTest {
    
    @Test
    void testQuickSort_EmptyArray_NoChange() {
        int[] arr = {};
        QuickSort.quickSort(arr);
        assertEquals(0, arr.length);
    }
    
    @Test
    void testQuickSort_SingleElement_NoChange() {
        int[] arr = {42};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }
    
    @Test
    void testQuickSort_RandomOrder_SortsCorrectly() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 5, 7, 8, 9, 10}, arr);
    }
    
    @Test
    void testQuickSort_AlreadySorted_HandlesCorrectly() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testQuickSort_ReverseSorted_SortsCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testQuickSort_WithDuplicates_HandlesCorrectly() {
        int[] arr = {3, 1, 3, 2, 1, 2};
        int[] expected = {1, 1, 2, 2, 3, 3};
        
        QuickSort.quickSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testQuickSort_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-5, 3, -1, 0, 7, -3};
        int[] expected = {-5, -3, -1, 0, 3, 7};
        
        QuickSort.quickSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testQuickSort_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        
        QuickSort.quickSort(arr);
        
        assertEquals(Integer.MIN_VALUE, arr[0]);
        assertEquals(Integer.MAX_VALUE, arr[4]);
        
        // Verify sorted order
        for (int i = 0; i < 4; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
    
    @Test
    void testQuickSort_LargeArray_HandlesCorrectly() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 999 - i; // Reverse order
        }
        
        QuickSort.quickSort(arr);
        
        // Verify sorted
        for (int i = 0; i < 999; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
        assertEquals(0, arr[0]);
        assertEquals(999, arr[999]);
    }
    
    @Test
    void testQuickSort_NullArray_NoException() {
        assertDoesNotThrow(() -> QuickSort.quickSort(null));
    }
    
    @Test
    void testQuickSort_TwoElements_SortsCorrectly() {
        int[] arr = {2, 1};
        QuickSort.quickSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
        
        int[] arr2 = {1, 2};
        QuickSort.quickSort(arr2);
        assertArrayEquals(new int[]{1, 2}, arr2);
    }
    
    @Test
    void testQuickSort_AllSameElements_HandlesCorrectly() {
        int[] arr = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        
        QuickSort.quickSort(arr);
        assertArrayEquals(expected, arr);
    }
}