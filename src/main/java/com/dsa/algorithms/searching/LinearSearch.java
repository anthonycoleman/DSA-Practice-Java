package com.dsa.algorithms.searching;

/**
 * Linear Search Implementation
 * 
 * Time Complexity: O(n) in worst case, O(1) in best case
 * Space Complexity: O(1)
 * 
 * Linear Search (Sequential Search) checks every element in the array sequentially
 * until the target element is found or the end of the array is reached.
 * 
 * Test this implementation:
 * ./gradlew test --tests "LinearSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.searching.LinearSearchTest"
 * ./gradlew test --tests "*LinearSearch*"
 */
public class LinearSearch {
    
    /**
     * Searches for a target value in an array using linear search
     * @param arr the array to search in
     * @param target the value to search for
     * @return index of target if found, -1 if not found
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
}