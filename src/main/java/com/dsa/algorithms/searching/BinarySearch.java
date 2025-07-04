package com.dsa.algorithms.searching;

/**
 * Binary Search Implementation
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1) for iterative version
 * 
 * Binary Search works on sorted arrays by repeatedly dividing the search interval in half.
 * It compares the target with the middle element and eliminates half of the remaining elements.
 * 
 * Prerequisites: The input array must be sorted in ascending order.
 * 
 * Test this implementation:
 * ./gradlew test --tests "BinarySearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.searching.BinarySearchTest"
 * ./gradlew test --tests "*BinarySearch*"
 */
public class BinarySearch {
    
    /**
     * Searches for a target value in a sorted array using binary search
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @return index of target if found, -1 if not found
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