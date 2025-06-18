package com.dsa.algorithms.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicProgrammingTest {

    @BeforeEach
    void setUp() {
        DynamicProgramming.resetFibonacciMemo(); // Reset memo for each test if needed
    }

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, DynamicProgramming.fibonacciRecursive(0));
        assertEquals(1, DynamicProgramming.fibonacciRecursive(1));
        assertEquals(1, DynamicProgramming.fibonacciRecursive(2));
        assertEquals(55, DynamicProgramming.fibonacciRecursive(10));
        // A higher value like 40 would be too slow for the naive version, which is the point.
    }

    @Test
    void testFibonacciWithMemoization() {
        assertEquals(0, DynamicProgramming.fibonacciWithMemoization(0));
        assertEquals(1, DynamicProgramming.fibonacciWithMemoization(1));
        assertEquals(55, DynamicProgramming.fibonacciWithMemoization(10));
        assertEquals(102334155, DynamicProgramming.fibonacciWithMemoization(40)); // Should be fast
    }

    @Test
    void testFibonacciWithTabulation() {
        assertEquals(0, DynamicProgramming.fibonacciWithTabulation(0));
        assertEquals(1, DynamicProgramming.fibonacciWithTabulation(1));
        assertEquals(55, DynamicProgramming.fibonacciWithTabulation(10));
        assertEquals(102334155, DynamicProgramming.fibonacciWithTabulation(40)); // Should be fast
    }

    @Test
    void testClimbStairs() {
        assertEquals(1, DynamicProgramming.climbStairs(0)); // 1 way (do nothing)
        assertEquals(1, DynamicProgramming.climbStairs(1)); // 1 way (1 step)
        assertEquals(2, DynamicProgramming.climbStairs(2)); // (1,1), (2)
        assertEquals(3, DynamicProgramming.climbStairs(3)); // (1,1,1), (1,2), (2,1)
        assertEquals(5, DynamicProgramming.climbStairs(4)); // (1,1,1,1), (1,1,2), (1,2,1), (2,1,1), (2,2)
        assertEquals(89, DynamicProgramming.climbStairs(10));

        // Test for negative input
        assertThrows(IllegalArgumentException.class, () -> {
            DynamicProgramming.climbStairs(-1);
        });
    }
}
