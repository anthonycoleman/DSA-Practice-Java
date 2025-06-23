package com.dsa.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of dynamic programming algorithms
 */
public class DynamicProgramming {
    
    /**
     * Naive recursive Fibonacci
     * Time: O(2^n), Space: O(n)
     */
    public static long fibonacciRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;
        
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    /**
     * Fibonacci with memoization (top-down DP)
     * Time: O(n), Space: O(n)
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
    
    /**
     * Fibonacci with tabulation (bottom-up DP)
     * Time: O(n), Space: O(1)
     */
    public static long fibonacciWithTabulation(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;
        
        long prev2 = 0;
        long prev1 = 1;
        long current = 0;
        
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}