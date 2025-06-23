package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Selection Sort algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "SelectionSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.SelectionSortTest"
 * ./gradlew test --tests "*SelectionSort*"
 */
class SelectionSortTest {
    
    @Test
    void testSelectionSort_EmptyArray_NoChange() {
        int[] arr = {};
        SelectionSort.selectionSort(arr);
        assertEquals(0, arr.length);
    }
    
    @Test
    void testSelectionSort_SingleElement_NoChange() {
        int[] arr = {5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }
    
    @Test
    void testSelectionSort_RandomOrder_SortsCorrectly() {
        int[] arr = {64, 25, 12, 22, 11};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 64}, arr);
    }
    
    @Test
    void testSelectionSort_AlreadySorted_HandlesCorrectly() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testSelectionSort_ReverseSorted_SortsCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testSelectionSort_WithDuplicates_HandlesCorrectly() {
        int[] arr = {3, 1, 3, 2, 1, 2};
        int[] expected = {1, 1, 2, 2, 3, 3};
        
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testSelectionSort_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-5, 3, -1, 0, 7, -3};
        int[] expected = {-5, -3, -1, 0, 3, 7};
        
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testSelectionSort_AllSameElements_HandlesCorrectly() {
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        
        SelectionSort.selectionSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testSelectionSort_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        
        SelectionSort.selectionSort(arr);
        
        assertEquals(Integer.MIN_VALUE, arr[0]);
        assertEquals(Integer.MAX_VALUE, arr[4]);
        
        // Verify sorted order
        for (int i = 0; i < 4; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
    
    @Test
    void testSelectionSort_NullArray_NoException() {
        assertDoesNotThrow(() -> SelectionSort.selectionSort(null));
    }
    
    @Test
    void testSelectionSort_TwoElements_SortsCorrectly() {
        int[] arr = {2, 1};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
        
        int[] arr2 = {1, 2};
        SelectionSort.selectionSort(arr2);
        assertArrayEquals(new int[]{1, 2}, arr2);
    }
    
    @Test
    void testSelectionSort_FindsMinimumCorrectly() {
        // Test that selection sort correctly finds minimum in each pass
        int[] arr = {7, 2, 9, 1, 5};
        SelectionSort.selectionSort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 7, 9}, arr);
    }
}