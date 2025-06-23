package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Insertion Sort algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "InsertionSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.InsertionSortTest"
 * ./gradlew test --tests "*InsertionSort*"
 */
class InsertionSortTest {
    
    @Test
    void testInsertionSort_EmptyArray_NoChange() {
        int[] arr = {};
        InsertionSort.insertionSort(arr);
        assertEquals(0, arr.length);
    }
    
    @Test
    void testInsertionSort_SingleElement_NoChange() {
        int[] arr = {5};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }
    
    @Test
    void testInsertionSort_RandomOrder_SortsCorrectly() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, arr);
    }
    
    @Test
    void testInsertionSort_AlreadySorted_HandlesCorrectly() {
        int[] arr = {1, 2, 3, 4, 5};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testInsertionSort_ReverseSorted_SortsCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testInsertionSort_WithDuplicates_HandlesCorrectly() {
        int[] arr = {3, 1, 3, 2, 1, 2};
        int[] expected = {1, 1, 2, 2, 3, 3};
        
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testInsertionSort_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-5, 3, -1, 0, 7, -3};
        int[] expected = {-5, -3, -1, 0, 3, 7};
        
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testInsertionSort_AllSameElements_HandlesCorrectly() {
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        
        InsertionSort.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testInsertionSort_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        
        InsertionSort.insertionSort(arr);
        
        assertEquals(Integer.MIN_VALUE, arr[0]);
        assertEquals(Integer.MAX_VALUE, arr[4]);
        
        // Verify sorted order
        for (int i = 0; i < 4; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
    
    @Test
    void testInsertionSort_NullArray_NoException() {
        assertDoesNotThrow(() -> InsertionSort.insertionSort(null));
    }
    
    @Test
    void testInsertionSort_TwoElements_SortsCorrectly() {
        int[] arr = {2, 1};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
        
        int[] arr2 = {1, 2};
        InsertionSort.insertionSort(arr2);
        assertArrayEquals(new int[]{1, 2}, arr2);
    }
    
    @Test
    void testInsertionSort_Nearlysorted_Efficient() {
        // Insertion sort should be efficient on nearly sorted arrays
        int[] arr = {1, 2, 3, 5, 4, 6, 7, 8, 9};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }
    
    @Test
    void testInsertionSort_InsertsCorrectly() {
        // Test that elements are inserted in correct position
        int[] arr = {3, 1, 4};
        InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 3, 4}, arr);
    }
}