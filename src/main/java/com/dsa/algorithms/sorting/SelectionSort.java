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
        
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}