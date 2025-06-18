package com.dsa.algorithms.sorting;

public class Sorting {

    /**
     * Sorts an array of integers in ascending order using the Bubble Sort algorithm.
     * Time Complexity: O(n^2) average and worst case. O(n) best case.
     * Space Complexity: O(1).
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array of integers in ascending order using the Selection Sort algorithm.
     * Time Complexity: O(n^2) best, average, and worst case.
     * Space Complexity: O(1).
     */
    public void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Sorts an array of integers in ascending order using the Insertion Sort algorithm.
     * Time Complexity: O(n^2) average and worst case. O(n) best case.
     * Space Complexity: O(1).
     */
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts an array of integers in ascending order using the Merge Sort algorithm.
     * Time Complexity: O(n log n) best, average, and worst case.
     * Space Complexity: O(n).
     */
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temp arrays
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;       // Initial index of first subarray
        int j = mid + 1;    // Initial index of second subarray
        int k = left;       // Initial index of merged subarray

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of left subarray if any
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        // Copy remaining elements of right subarray if any
        // (this part is often not needed if the right subarray is exhausted first,
        // as its elements would already be in place in the original array if it were the larger one)
        while (j <= right) {
            arr[k] = temp[j];
            k++;
            j++;
        }
    }

    /**
     * Sorts an array of integers in ascending order using the Quick Sort algorithm.
     * Time Complexity: O(n log n) best and average case. O(n^2) worst case.
     * Space Complexity: O(log n).
     */
    public void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
