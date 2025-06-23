package com.dsa.algorithms.sorting;

/**
 * Bubble Sort Implementation
 * 
 * Time Complexity: O(n²) in worst and average case, O(n) in best case (already sorted)
 * Space Complexity: O(1) - in-place sorting algorithm
 * 
 * Bubble Sort repeatedly steps through the list, compares adjacent elements and swaps 
 * them if they are in the wrong order. The pass through the list is repeated until 
 * the list is sorted.
 * 
 * Test this implementation:
 * ./gradlew test --tests "BubbleSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.BubbleSortTest"
 * ./gradlew test --tests "*BubbleSort*"
 */
public class BubbleSort {
    
    /**
     * Sorts an array using the bubble sort algorithm
     * @param arr the array to be sorted (modified in-place)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: if no swaps, array is sorted
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}