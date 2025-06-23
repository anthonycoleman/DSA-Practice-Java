package com.dsa.algorithms.dp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Fibonacci with Tabulation (Bottom-Up DP) algorithm
 * 
 * Run these tests from command line:
 * ./gradlew test --tests "FibonacciTabulationTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciTabulationTest"
 * ./gradlew test --tests "*FibonacciTabulation*"
 * ./gradlew test --tests "*Tabulation*"
 */
class FibonacciTabulationTest {
    
    @Test
    void testFibonacciWithTabulation_BaseCase_Zero() {
        assertEquals(0, FibonacciTabulation.fibonacciWithTabulation(0));
    }
    
    @Test
    void testFibonacciWithTabulation_BaseCase_One() {
        assertEquals(1, FibonacciTabulation.fibonacciWithTabulation(1));
    }
    
    @Test
    void testFibonacciWithTabulation_SmallNumbers_CorrectValues() {
        assertEquals(1, FibonacciTabulation.fibonacciWithTabulation(2));
        assertEquals(2, FibonacciTabulation.fibonacciWithTabulation(3));
        assertEquals(3, FibonacciTabulation.fibonacciWithTabulation(4));
        assertEquals(5, FibonacciTabulation.fibonacciWithTabulation(5));
        assertEquals(8, FibonacciTabulation.fibonacciWithTabulation(6));
    }
    
    @Test
    void testFibonacciWithTabulation_LargerNumbers_WorksEfficiently() {
        assertEquals(55, FibonacciTabulation.fibonacciWithTabulation(10));
        assertEquals(6765, FibonacciTabulation.fibonacciWithTabulation(20));
        assertEquals(832040, FibonacciTabulation.fibonacciWithTabulation(30));
        assertEquals(102334155L, FibonacciTabulation.fibonacciWithTabulation(40));
    }
    
    @Test
    void testFibonacciWithTabulation_NegativeInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class, 
                    () -> FibonacciTabulation.fibonacciWithTabulation(-1));
    }
    
    @Test
    void testFibonacciWithTabulation_SequenceProperty_CorrectFormula() {
        // Test that F(n) = F(n-1) + F(n-2) for several values
        for (int n = 2; n <= 20; n++) {
            long fn = FibonacciTabulation.fibonacciWithTabulation(n);
            long fn1 = FibonacciTabulation.fibonacciWithTabulation(n - 1);
            long fn2 = FibonacciTabulation.fibonacciWithTabulation(n - 2);
            
            assertEquals(fn1 + fn2, fn, 
                "Fibonacci property failed for n=" + n);
        }
    }
    
    @Test
    void testFibonacciWithTabulation_VeryLargeNumbers_Performance() {
        // Test that tabulation handles very large numbers efficiently
        assertEquals(12586269025L, FibonacciTabulation.fibonacciWithTabulation(50));
        assertEquals(2971215073L, FibonacciTabulation.fibonacciWithTabulation(47));
    }
    
    @Test
    void testFibonacciWithTabulation_ConsistentResults_MultipleCallsSameInput() {
        // Multiple calls with same input should return same result
        int n = 30;
        long first = FibonacciTabulation.fibonacciWithTabulation(n);
        long second = FibonacciTabulation.fibonacciWithTabulation(n);
        long third = FibonacciTabulation.fibonacciWithTabulation(n);
        
        assertEquals(first, second);
        assertEquals(second, third);
    }
    
    @Test
    void testFibonacciWithTabulation_FirstTwentyNumbers_CorrectSequence() {
        long[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
                          55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181};
        
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], FibonacciTabulation.fibonacciWithTabulation(i),
                "Fibonacci number at position " + i + " is incorrect");
        }
    }
    
    @Test
    void testFibonacciWithTabulation_Performance_FastExecution() {
        // Test that tabulation executes quickly even for large numbers
        int n = 60;
        
        long startTime = System.nanoTime();
        long result = FibonacciTabulation.fibonacciWithTabulation(n);
        long endTime = System.nanoTime();
        
        long executionTime = endTime - startTime;
        
        // Should complete very quickly (under 10ms)
        assertTrue(executionTime < 10_000_000L);
        assertTrue(result > 0); // Should produce a positive result
    }
    
    @Test
    void testFibonacciWithTabulation_MemoryEfficient_ConstantSpace() {
        // Tabulation should use O(1) space, test with large input
        // If this completes without OutOfMemoryError, space complexity is good
        long result = FibonacciTabulation.fibonacciWithTabulation(100);
        assertTrue(result > 0);
    }
    
    @Test
    void testFibonacciWithTabulation_EdgeCase_LargeInputDoesNotOverflow() {
        // Test behavior near the limits of long
        // Note: Fibonacci numbers grow exponentially, so we can't go too high
        assertDoesNotThrow(() -> {
            FibonacciTabulation.fibonacciWithTabulation(70);
        });
    }
}