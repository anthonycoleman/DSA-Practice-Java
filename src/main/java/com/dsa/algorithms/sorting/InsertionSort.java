package com.dsa.algorithms.sorting;

/**
 * Insertion Sort Implementation
 * 
 * Time Complexity: O(n²) worst and average case, O(n) best case (nearly sorted)
 * Space Complexity: O(1) - in-place sorting algorithm
 * 
 * Insertion Sort builds the sorted array one element at a time. It takes elements
 * from the unsorted portion and inserts them into their correct position in the sorted portion.
 * 
 * Test this implementation:
 * ./gradlew test --tests "InsertionSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.InsertionSortTest"
 * ./gradlew test --tests "*InsertionSort*"
 */
public class InsertionSort {
    
    /**
     * Sorts an array using the insertion sort algorithm
     * @param arr the array to be sorted (modified in-place)
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}