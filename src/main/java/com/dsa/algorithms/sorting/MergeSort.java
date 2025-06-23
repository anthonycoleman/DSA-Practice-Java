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
        
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}