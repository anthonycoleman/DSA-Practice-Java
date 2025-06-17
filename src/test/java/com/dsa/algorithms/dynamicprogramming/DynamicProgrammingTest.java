package com.dsa.algorithms.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DynamicProgrammingTest {

    private DynamicProgramming dp;

    @BeforeEach
    void setUp() {
        dp = new DynamicProgramming();
    }

    @Test
    void testFibonacciRecursive() {
        assertEquals(0, dp.fibonacciRecursive(0));
        assertEquals(1, dp.fibonacciRecursive(1));
        assertEquals(1, dp.fibonacciRecursive(2));
        assertEquals(55, dp.fibonacciRecursive(10));
        // A higher value like 40 would be too slow for the naive version, which is the point.
    }

    @Test
    void testFibonacciWithMemoization() {
        assertEquals(0, dp.fibonacciWithMemoization(0));
        assertEquals(1, dp.fibonacciWithMemoization(1));
        assertEquals(55, dp.fibonacciWithMemoization(10));
        assertEquals(102334155, dp.fibonacciWithMemoization(40)); // Should be fast
    }

    @Test
    void testFibonacciWithTabulation() {
        assertEquals(0, dp.fibonacciWithTabulation(0));
        assertEquals(1, dp.fibonacciWithTabulation(1));
        assertEquals(55, dp.fibonacciWithTabulation(10));
        assertEquals(102334155, dp.fibonacciWithTabulation(40)); // Should be fast
    }
}
