package com.dsa.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Recursive Fibonacci algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "FibonacciRecursiveTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciRecursiveTest"
 * ./gradlew test --tests "*FibonacciRecursive*"
 */
class FibonacciRecursiveTest {
    
    @Test
    void testFibonacciRecursive_BaseCase_Zero() {
        assertEquals(0, FibonacciRecursive.fibonacciRecursive(0));
    }
    
    @Test
    void testFibonacciRecursive_BaseCase_One() {
        assertEquals(1, FibonacciRecursive.fibonacciRecursive(1));
    }
    
    @Test
    void testFibonacciRecursive_SmallNumbers_CorrectValues() {
        assertEquals(1, FibonacciRecursive.fibonacciRecursive(2));
        assertEquals(2, FibonacciRecursive.fibonacciRecursive(3));
        assertEquals(3, FibonacciRecursive.fibonacciRecursive(4));
        assertEquals(5, FibonacciRecursive.fibonacciRecursive(5));
        assertEquals(8, FibonacciRecursive.fibonacciRecursive(6));
    }
    
    @Test
    void testFibonacciRecursive_NegativeInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> FibonacciRecursive.fibonacciRecursive(-1));
    }
    
    @Test
    void testFibonacciRecursive_SequenceProperty_CorrectFormula() {
        // Test that F(n) = F(n-1) + F(n-2) for several values
        for (int n = 2; n <= 8; n++) {
            long fn = FibonacciRecursive.fibonacciRecursive(n);
            long fn1 = FibonacciRecursive.fibonacciRecursive(n - 1);
            long fn2 = FibonacciRecursive.fibonacciRecursive(n - 2);
            
            assertEquals(fn1 + fn2, fn, 
                "Fibonacci property failed for n=" + n);
        }
    }
    
    @Test
    void testFibonacciRecursive_KnownValues_CorrectResults() {
        // Test some well-known Fibonacci numbers
        assertEquals(13, FibonacciRecursive.fibonacciRecursive(7));
        assertEquals(21, FibonacciRecursive.fibonacciRecursive(8));
        assertEquals(34, FibonacciRecursive.fibonacciRecursive(9));
        assertEquals(55, FibonacciRecursive.fibonacciRecursive(10));
    }
    
    @Test
    void testFibonacciRecursive_ModerateNumbers_StillWorks() {
        // These will be slow due to exponential time complexity
        // but should still work for testing correctness
        assertEquals(89, FibonacciRecursive.fibonacciRecursive(11));
        assertEquals(144, FibonacciRecursive.fibonacciRecursive(12));
        assertEquals(233, FibonacciRecursive.fibonacciRecursive(13));
    }
    
    @Test
    void testFibonacciRecursive_FirstTenNumbers_CorrectSequence() {
        long[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], FibonacciRecursive.fibonacciRecursive(i),
                "Fibonacci number at position " + i + " is incorrect");
        }
    }
}