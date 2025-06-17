package com.dsa.algorithms.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchingTest {

    private Searching searcher;

    @BeforeEach
    void setUp() {
        searcher = new Searching();
    }

    @Test
    void testLinearSearch() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        assertEquals(3, searcher.linearSearch(arr, 12), "Target in middle failed");
        assertEquals(0, searcher.linearSearch(arr, 2), "Target at start failed");
        assertEquals(9, searcher.linearSearch(arr, 91), "Target at end failed");
        assertEquals(-1, searcher.linearSearch(arr, 15), "Target not present failed");
        assertEquals(-1, searcher.linearSearch(new int[]{}, 5), "Empty array failed");
        assertEquals(0, searcher.linearSearch(new int[]{42}, 42), "Single element found failed");
        assertEquals(-1, searcher.linearSearch(new int[]{42}, 10), "Single element not found failed");
    }

    @Test
    void testBinarySearch() {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        assertEquals(3, searcher.binarySearch(arr, 12), "Target in middle failed");
        assertEquals(0, searcher.binarySearch(arr, 2), "Target at start failed");
        assertEquals(9, searcher.binarySearch(arr, 91), "Target at end failed");
        assertEquals(-1, searcher.binarySearch(arr, 15), "Target not present failed");
        assertEquals(-1, searcher.binarySearch(new int[]{}, 5), "Empty array failed");
        assertEquals(0, searcher.binarySearch(new int[]{42}, 42), "Single element found failed");
        assertEquals(-1, searcher.binarySearch(new int[]{42}, 10), "Single element not found failed");
    }
}
