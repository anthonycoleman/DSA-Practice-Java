package com.dsa.algorithms.sorting;

/**
 * Selection Sort Implementation
 * 
 * Time Complexity: O(n²) in all cases (worst, average, best)
 * Space Complexity: O(1) - in-place sorting algorithm
 * 
 * Selection Sort divides the list into sorted and unsorted regions. It repeatedly
 * finds the minimum element from the unsorted region and moves it to the sorted region.
 * 
 * Test this implementation:
 * ./gradlew test --tests "SelectionSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.SelectionSortTest"
 * ./gradlew test --tests "*SelectionSort*"
 */
public class SelectionSort {
    
    /**
     * Sorts an array using the selection sort algorithm
     * @param arr the array to be sorted (modified in-place)
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        // TODO: Implement selection sort algorithm
        // Hint: Find the minimum element in the unsorted portion and swap it with the first element
    }
    
    private static void swap(int[] arr, int i, int j) {
        // TODO: Implement swap method
        // Hint: Use a temporary variable to swap elements at indices i and j
    }
}