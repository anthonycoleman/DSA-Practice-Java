package com.dsa.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class SortingTest {

    private Sorting sorter;

    @BeforeEach
    void setUp() {
        sorter = new Sorting();
    }

    private void runSortingTests(SortFunction sortFunction) {
        // Test case 1: Standard unsorted array
        int[] arr1 = {5, 1, 4, 2, 8};
        int[] expected1 = {1, 2, 4, 5, 8};
        sortFunction.sort(arr1);
        assertArrayEquals(expected1, arr1, "Standard case failed");

        // Test case 2: Array with duplicates
        int[] arr2 = {5, 1, 4, 2, 8, 5, 2};
        int[] expected2 = {1, 2, 2, 4, 5, 5, 8};
        sortFunction.sort(arr2);
        assertArrayEquals(expected2, arr2, "Duplicates case failed");

        // Test case 3: Already sorted array
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] expected3 = {1, 2, 3, 4, 5};
        sortFunction.sort(arr3);
        assertArrayEquals(expected3, arr3, "Already sorted case failed");

        // Test case 4: Reverse sorted array
        int[] arr4 = {5, 4, 3, 2, 1};
        int[] expected4 = {1, 2, 3, 4, 5};
        sortFunction.sort(arr4);
        assertArrayEquals(expected4, arr4, "Reverse sorted case failed");

        // Test case 5: Array with negative numbers
        int[] arr5 = {-5, 1, -4, 2, 0};
        int[] expected5 = {-5, -4, 0, 1, 2};
        sortFunction.sort(arr5);
        assertArrayEquals(expected5, arr5, "Negative numbers case failed");

        // Test case 6: Empty array
        int[] arr6 = {};
        int[] expected6 = {};
        sortFunction.sort(arr6);
        assertArrayEquals(expected6, arr6, "Empty array case failed");

        // Test case 7: Single element array
        int[] arr7 = {42};
        int[] expected7 = {42};
        sortFunction.sort(arr7);
        assertArrayEquals(expected7, arr7, "Single element case failed");
    }

    @Test
    void testBubbleSort() {
        runSortingTests(sorter::bubbleSort);
    }

    @Test
    void testSelectionSort() {
        runSortingTests(sorter::selectionSort);
    }

    @Test
    void testInsertionSort() {
        runSortingTests(sorter::insertionSort);
    }

    @Test
    void testMergeSort() {
        runSortingTests(sorter::mergeSort);
    }

    @Test
    void testQuickSort() {
        runSortingTests(sorter::quickSort);
    }

    @FunctionalInterface
    interface SortFunction {
        void sort(int[] arr);
    }
}
