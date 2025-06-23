package com.dsa.algorithms.searching;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Binary Search algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "BinarySearchTest"
 * ./gradlew test --tests "com.dsa.algorithms.searching.BinarySearchTest"
 * ./gradlew test --tests "*BinarySearch*"
 */
class BinarySearchTest {
    
    @Test
    void testBinarySearch_ElementExists_ReturnsCorrectIndex() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
        assertEquals(2, BinarySearch.binarySearch(arr, 5));
        assertEquals(5, BinarySearch.binarySearch(arr, 11));
    }
    
    @Test
    void testBinarySearch_ElementNotExists_ReturnsMinusOne() {
        int[] arr = {2, 4, 6, 8, 10};
        assertEquals(-1, BinarySearch.binarySearch(arr, 1));
        assertEquals(-1, BinarySearch.binarySearch(arr, 5));
        assertEquals(-1, BinarySearch.binarySearch(arr, 12));
    }
    
    @Test
    void testBinarySearch_EmptyArray_ReturnsMinusOne() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 5));
    }
    
    @Test
    void testBinarySearch_NullArray_ReturnsMinusOne() {
        assertEquals(-1, BinarySearch.binarySearch(null, 5));
    }
    
    @Test
    void testBinarySearch_SingleElement_Found() {
        int[] arr = {42};
        assertEquals(0, BinarySearch.binarySearch(arr, 42));
    }
    
    @Test
    void testBinarySearch_SingleElement_NotFound() {
        int[] arr = {42};
        assertEquals(-1, BinarySearch.binarySearch(arr, 43));
    }
    
    @Test
    void testBinarySearch_TwoElements_BothFound() {
        int[] arr = {1, 3};
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
        assertEquals(1, BinarySearch.binarySearch(arr, 3));
    }
    
    @Test
    void testBinarySearch_TwoElements_NotFound() {
        int[] arr = {1, 3};
        assertEquals(-1, BinarySearch.binarySearch(arr, 0));
        assertEquals(-1, BinarySearch.binarySearch(arr, 2));
        assertEquals(-1, BinarySearch.binarySearch(arr, 4));
    }
    
    @Test
    void testBinarySearch_WithNegativeNumbers_HandlesCorrectly() {
        int[] arr = {-10, -5, -1, 0, 3, 7, 15};
        
        assertEquals(0, BinarySearch.binarySearch(arr, -10));
        assertEquals(3, BinarySearch.binarySearch(arr, 0));
        assertEquals(6, BinarySearch.binarySearch(arr, 15));
        assertEquals(-1, BinarySearch.binarySearch(arr, -3));
    }
    
    @Test
    void testBinarySearch_ExtremeValues_HandlesCorrectly() {
        int[] arr = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        
        assertEquals(0, BinarySearch.binarySearch(arr, Integer.MIN_VALUE));
        assertEquals(4, BinarySearch.binarySearch(arr, Integer.MAX_VALUE));
        assertEquals(2, BinarySearch.binarySearch(arr, 0));
    }
    
    @Test
    void testBinarySearch_InLargeArray_Performance() {
        int[] largeArray = new int[100000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2; // Even numbers
        }
        
        assertEquals(25000, BinarySearch.binarySearch(largeArray, 50000));
        assertEquals(0, BinarySearch.binarySearch(largeArray, 0));
        assertEquals(99999, BinarySearch.binarySearch(largeArray, 199998));
        assertEquals(-1, BinarySearch.binarySearch(largeArray, 50001)); // Odd number
    }
    
    @Test
    void testBinarySearch_EdgeCases_BoundaryConditions() {
        // Test with arrays of different sizes around binary search decision points
        
        // Size 2
        int[] arr2 = {1, 3};
        assertEquals(0, BinarySearch.binarySearch(arr2, 1));
        assertEquals(1, BinarySearch.binarySearch(arr2, 3));
        assertEquals(-1, BinarySearch.binarySearch(arr2, 2));
        
        // Size 3
        int[] arr3 = {1, 3, 5};
        assertEquals(0, BinarySearch.binarySearch(arr3, 1));
        assertEquals(1, BinarySearch.binarySearch(arr3, 3));
        assertEquals(2, BinarySearch.binarySearch(arr3, 5));
        assertEquals(-1, BinarySearch.binarySearch(arr3, 4));
        
        // Size 4
        int[] arr4 = {1, 3, 5, 7};
        assertEquals(0, BinarySearch.binarySearch(arr4, 1));
        assertEquals(1, BinarySearch.binarySearch(arr4, 3));
        assertEquals(2, BinarySearch.binarySearch(arr4, 5));
        assertEquals(3, BinarySearch.binarySearch(arr4, 7));
        assertEquals(-1, BinarySearch.binarySearch(arr4, 6));
    }
    
    @Test
    void testBinarySearch_AllSameElements_HandlesCorrectly() {
        int[] allSame = {5, 5, 5, 5, 5};
        
        int result = BinarySearch.binarySearch(allSame, 5);
        assertTrue(result >= 0 && result < allSame.length);
        
        assertEquals(-1, BinarySearch.binarySearch(allSame, 4));
        assertEquals(-1, BinarySearch.binarySearch(allSame, 6));
    }
    
    @Test
    void testBinarySearch_WithZeroValues_HandlesCorrectly() {
        int[] withZeros = {-2, -1, 0, 0, 0, 1, 2};
        
        int result = BinarySearch.binarySearch(withZeros, 0);
        assertTrue(result >= 2 && result <= 4); // Any of the zero positions is valid
        
        assertEquals(0, BinarySearch.binarySearch(withZeros, -2));
        assertEquals(6, BinarySearch.binarySearch(withZeros, 2));
    }
}