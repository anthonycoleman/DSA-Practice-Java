package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Merge Sort algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "MergeSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.MergeSortTest"
 * ./gradlew test --tests "*MergeSort*"
 */
class MergeSortTest {
    
    @Test
    void testMergeSort_EmptyArray_NoChange() {
        int[] arr = {};
        MergeSort.mergeSort(arr);
        assertEquals(0, arr.length);
    }
    
    @Test
    void testMergeSort_SingleElement_NoChange() {
        int[] arr = {42};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }
    
    @Test
    void testMergeSort_LargeArray_SortsCorrectly() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{3, 9, 10, 27, 38, 43, 82}, arr);
    }
    
    @Test
    void testMergeSort_AlreadySorted_HandlesCorrectly() {
        int[] arr = {1, 2, 3, 4, 5};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testMergeSort_ReverseSorted_SortsCorrectly() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    
    @Test
    void testMergeSort_WithDuplicates_HandlesCorrectly() {
        int[] arr = {3, 1, 3, 2, 1, 2};
        int[] expected = {1, 1, 2, 2, 3, 3};
        
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testMergeSort_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-5, 3, -1, 0, 7, -3};
        int[] expected = {-5, -3, -1, 0, 3, 7};
        
        MergeSort.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
    
    @Test
    void testMergeSort_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        
        MergeSort.mergeSort(arr);
        
        assertEquals(Integer.MIN_VALUE, arr[0]);
        assertEquals(Integer.MAX_VALUE, arr[4]);
        
        // Verify sorted order
        for (int i = 0; i < 4; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
    
    @Test
    void testMergeSort_LargeArray_Performance() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 999 - i; // Reverse order
        }
        
        MergeSort.mergeSort(arr);
        
        // Verify sorted
        for (int i = 0; i < 999; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
        assertEquals(0, arr[0]);
        assertEquals(999, arr[999]);
    }
    
    @Test
    void testMergeSort_NullArray_NoException() {
        assertDoesNotThrow(() -> MergeSort.mergeSort(null));
    }
    
    @Test
    void testMergeSort_TwoElements_SortsCorrectly() {
        int[] arr = {2, 1};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2}, arr);
        
        int[] arr2 = {1, 2};
        MergeSort.mergeSort(arr2);
        assertArrayEquals(new int[]{1, 2}, arr2);
    }
    
    @Test
    void testMergeSort_PowerOfTwoSize_HandlesCorrectly() {
        // Test with sizes that are powers of 2 (common in merge sort analysis)
        int[] arr4 = {4, 3, 2, 1};
        MergeSort.mergeSort(arr4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, arr4);
        
        int[] arr8 = {8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort.mergeSort(arr8);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr8);
    }
    
    @Test
    void testMergeSort_OddNumberOfElements_HandlesCorrectly() {
        int[] arr = {5, 2, 8, 1, 9};
        MergeSort.mergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }
}