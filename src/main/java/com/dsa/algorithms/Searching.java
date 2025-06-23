package com.dsa.algorithms;

/**
 * Implementation of fundamental searching algorithms
 */
public class Searching {
    
    /**
     * Linear search implementation
     * Time: O(n), Space: O(1)
     * @param arr array to search in
     * @param target value to search for
     * @return index of target, or -1 if not found
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Binary search implementation (requires sorted array)
     * Time: O(log n), Space: O(1)
     * @param arr sorted array to search in
     * @param target value to search for
     * @return index of target, or -1 if not found
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null) return -1;
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}