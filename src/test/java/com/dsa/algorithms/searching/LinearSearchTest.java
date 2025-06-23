package com.dsa.algorithms.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Linear Search algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "LinearSearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.searching.LinearSearchTest"
 * ./gradlew test --tests "*LinearSearch*"
 */
class LinearSearchTest {
    
    @Test
    void testLinearSearch_ElementExists_ReturnsCorrectIndex() {
        int[] arr = {5, 2, 8, 1, 9};
        assertEquals(0, LinearSearch.linearSearch(arr, 5));
        assertEquals(2, LinearSearch.linearSearch(arr, 8));
        assertEquals(4, LinearSearch.linearSearch(arr, 9));
    }
    
    @Test
    void testLinearSearch_ElementNotExists_ReturnsMinusOne() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, LinearSearch.linearSearch(arr, 2));
        assertEquals(-1, LinearSearch.linearSearch(arr, 10));
    }
    
    @Test
    void testLinearSearch_EmptyArray_ReturnsMinusOne() {
        int[] arr = {};
        assertEquals(-1, LinearSearch.linearSearch(arr, 5));
    }
    
    @Test
    void testLinearSearch_NullArray_ReturnsMinusOne() {
        assertEquals(-1, LinearSearch.linearSearch(null, 5));
    }
    
    @Test
    void testLinearSearch_SingleElement_Found() {
        int[] arr = {42};
        assertEquals(0, LinearSearch.linearSearch(arr, 42));
    }
    
    @Test
    void testLinearSearch_SingleElement_NotFound() {
        int[] arr = {42};
        assertEquals(-1, LinearSearch.linearSearch(arr, 43));
    }
    
    @Test
    void testLinearSearch_DuplicateElements_ReturnsFirstIndex() {
        int[] arr = {1, 3, 5, 3, 7};
        assertEquals(1, LinearSearch.linearSearch(arr, 3)); // Returns first occurrence
    }
    
    @Test
    void testLinearSearch_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-10, -5, -1, 0, 3, 7, 15};
        
        assertEquals(1, LinearSearch.linearSearch(arr, -5));
        assertEquals(4, LinearSearch.linearSearch(arr, 3));
        assertEquals(-1, LinearSearch.linearSearch(arr, 100));
    }
    
    @Test
    void testLinearSearch_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        
        assertEquals(0, LinearSearch.linearSearch(arr, Integer.MIN_VALUE));
        assertEquals(4, LinearSearch.linearSearch(arr, Integer.MAX_VALUE));
        assertEquals(-1, LinearSearch.linearSearch(arr, 2));
    }
    
    @Test
    void testLinearSearch_InLargeArray_WorksCorrectly() {
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2; // Even numbers
        }
        
        assertEquals(25000, LinearSearch.linearSearch(largeArray, 50000));
        assertEquals(-1, LinearSearch.linearSearch(largeArray, 50001)); // Odd number
    }
    
    @Test
    void testLinearSearch_FirstAndLastElements_WorksCorrectly() {
        int[] arr = {10, 20, 30, 40, 50};
        
        assertEquals(0, LinearSearch.linearSearch(arr, 10)); // First element
        assertEquals(4, LinearSearch.linearSearch(arr, 50)); // Last element
    }
    
    @Test
    void testLinearSearch_AllSameElements_FindsFirst() {
        int[] allSame = {5, 5, 5, 5, 5};
        
        int result = LinearSearch.linearSearch(allSame, 5);
        assertEquals(0, result); // Should find first occurrence
        
        assertEquals(-1, LinearSearch.linearSearch(allSame, 4));
    }
    
    @Test
    void testLinearSearch_WithZeroValues_HandlesCorrectly() {
        int[] withZeros = {-2, -1, 0, 0, 0, 1, 2};
        
        int result = LinearSearch.linearSearch(withZeros, 0);
        assertEquals(2, result); // Should find first zero
        
        assertEquals(0, LinearSearch.linearSearch(withZeros, -2));
        assertEquals(6, LinearSearch.linearSearch(withZeros, 2));
    }
}