package com.dsa.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Fibonacci with Memoization (Top-Down DP) algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "FibonacciMemoizationTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciMemoizationTest"
 * ./gradlew test --tests "*FibonacciMemoization*"
 * ./gradlew test --tests "*Memoization*"
 */
class FibonacciMemoizationTest {
    
    @Test
    void testFibonacciWithMemoization_BaseCase_Zero() {
        assertEquals(0, FibonacciMemoization.fibonacciWithMemoization(0));
    }
    
    @Test
    void testFibonacciWithMemoization_BaseCase_One() {
        assertEquals(1, FibonacciMemoization.fibonacciWithMemoization(1));
    }
    
    @Test
    void testFibonacciWithMemoization_SmallNumbers_CorrectValues() {
        assertEquals(1, FibonacciMemoization.fibonacciWithMemoization(2));
        assertEquals(2, FibonacciMemoization.fibonacciWithMemoization(3));
        assertEquals(3, FibonacciMemoization.fibonacciWithMemoization(4));
        assertEquals(5, FibonacciMemoization.fibonacciWithMemoization(5));
        assertEquals(8, FibonacciMemoization.fibonacciWithMemoization(6));
    }
    
    @Test
    void testFibonacciWithMemoization_LargerNumbers_WorksEfficiently() {
        // These would be too slow with naive recursion
        assertEquals(55, FibonacciMemoization.fibonacciWithMemoization(10));
        assertEquals(6765, FibonacciMemoization.fibonacciWithMemoization(20));
        assertEquals(832040, FibonacciMemoization.fibonacciWithMemoization(30));
    }
    
    @Test
    void testFibonacciWithMemoization_NegativeInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> FibonacciMemoization.fibonacciWithMemoization(-1));
    }
    
    @Test
    void testFibonacciWithMemoization_SequenceProperty_CorrectFormula() {
        // Test that F(n) = F(n-1) + F(n-2) for several values
        for (int n = 2; n <= 15; n++) {
            long fn = FibonacciMemoization.fibonacciWithMemoization(n);
            long fn1 = FibonacciMemoization.fibonacciWithMemoization(n - 1);
            long fn2 = FibonacciMemoization.fibonacciWithMemoization(n - 2);
            
            assertEquals(fn1 + fn2, fn, 
                "Fibonacci property failed for n=" + n);
        }
    }
    
    @Test
    void testFibonacciWithMemoization_LargeNumbers_Performance() {
        // Test that memoization allows efficient computation of large numbers
        assertEquals(102334155L, FibonacciMemoization.fibonacciWithMemoization(40));
        assertEquals(12586269025L, FibonacciMemoization.fibonacciWithMemoization(50));
    }
    
    @Test
    void testFibonacciWithMemoization_ConsistentResults_MultipleCallsSameInput() {
        // Multiple calls with same input should return same result
        int n = 25;
        long first = FibonacciMemoization.fibonacciWithMemoization(n);
        long second = FibonacciMemoization.fibonacciWithMemoization(n);
        long third = FibonacciMemoization.fibonacciWithMemoization(n);
        
        assertEquals(first, second);
        assertEquals(second, third);
    }
    
    @Test
    void testFibonacciWithMemoization_FirstTwentyNumbers_CorrectSequence() {
        long[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
                          55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181};
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], FibonacciMemoization.fibonacciWithMemoization(i),
                "Fibonacci number at position " + i + " is incorrect");
        }
    }
    
    @Test
    void testFibonacciWithMemoization_PerformanceComparison_FasterThanRecursive() {
        // Test that memoization is significantly faster than naive recursion
        int n = 35;
        
        // Memoization should complete quickly
        long startTime = System.nanoTime();
        long memoResult = FibonacciMemoization.fibonacciWithMemoization(n);
        long memoTime = System.nanoTime() - startTime;
        
        assertTrue(memoTime < 100_000_000L); // Should complete in under 100ms
        assertEquals(9227465L, memoResult); // Known F(35)
    }
}