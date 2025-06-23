package com.dsa.algorithms.sorting;

/**
 * Quick Sort Implementation
 * 
 * Time Complexity: O(n log n) average case, O(n²) worst case
 * Space Complexity: O(log n) due to recursion stack
 * 
 * Quick Sort is a divide-and-conquer algorithm that picks a 'pivot' element and
 * partitions the array around the pivot, then recursively sorts the sub-arrays.
 * 
 * Test this implementation:
 * ./gradlew test --tests "QuickSortTest"
 * ./gradlew test --tests "com.dsa.algorithms.sorting.QuickSortTest"
 * ./gradlew test --tests "*QuickSort*"
 */
public class QuickSort {
    
    /**
     * Sorts an array using the quick sort algorithm
     * @param arr the array to be sorted (modified in-place)
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            
            quickSortHelper(arr, low, partitionIndex - 1);
            quickSortHelper(arr, partitionIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}