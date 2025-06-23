package com.dsa.algorithms.sorting;

/**
 * Merge Sort Implementation
 * 
 * Time Complexity: O(n log n) in all cases (worst, average, best)
 * Space Complexity: O(n) for the temporary arrays used during merging
 * 
 * Merge Sort is a divide-and-conquer algorithm that divides the array into halves,
 * recursively sorts them, and then merges the sorted halves.
 * 
 * Test this implementation:
 * ./gradlew test --tests "MergeSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.MergeSortTest"
 * ./gradlew test --tests "*MergeSort*"
 */
public class MergeSort {
    
    /**
     * Sorts an array using the merge sort algorithm
     * @param arr the array to be sorted (modified in-place)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        // TODO: Implement merge sort algorithm
        // Hint: Use divide and conquer - split the array and recursively sort both halves
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right) {
        // TODO: Implement the recursive helper method
        // Hint: Divide the array, recursively sort both halves, then merge them
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // TODO: Implement the merge method
        // Hint: Create temporary arrays for left and right halves, then merge them back
    }
}