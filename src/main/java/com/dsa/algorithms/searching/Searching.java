package com.dsa.algorithms.searching;

public class Searching {

    /**
     * Finds the index of a target value in an array using Linear Search.
     * Time Complexity: O(n).
     * Space Complexity: O(1).
     * @param arr The array to search in.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    /**
     * Finds the index of a target value in a sorted array using Binary Search.
     * Time Complexity: O(log n).
     * Space Complexity: O(1) for iterative, O(log n) for recursive.
     * @param arr The sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    public int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        return -1; // Target not present in array
    }
}
