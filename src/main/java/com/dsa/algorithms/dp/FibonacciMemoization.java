package com.dsa.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci with Memoization Implementation (Top-Down Dynamic Programming)
 * 
 * Time Complexity: O(n) - each subproblem is calculated only once
 * Space Complexity: O(n) - for memoization table and recursion call stack
 * 
 * Memoization optimizes the naive recursive approach by storing the results of
 * subproblems in a cache (usually a HashMap). This eliminates redundant calculations
 * and dramatically improves performance.
 * 
 * This is a top-down approach where we start with the original problem and
 * break it down into smaller subproblems.
 * 
 * Test this implementation:
 * ./gradlew test --tests "FibonacciMemoizationTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciMemoizationTest"
 * ./gradlew test --tests "*FibonacciMemoization*"
 * ./gradlew test --tests "*Memoization*"
 */
public class FibonacciMemoization {
    
    /**
     * Calculates the nth Fibonacci number using memoization (top-down DP)
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static long fibonacciWithMemoization(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        
        Map<Integer, Long> memo = new HashMap<>();
        return fibonacciMemoHelper(n, memo);
    }
    
    private static long fibonacciMemoHelper(int n, Map<Integer, Long> memo) {
        if (n <= 1) return n;
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        long result = fibonacciMemoHelper(n - 1, memo) + fibonacciMemoHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }
}