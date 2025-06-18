package com.dsa.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    // Purely recursive Fibonacci (can be slow for large n)
    public static long fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Fibonacci with Tabulation (Bottom-Up DP)
    public static long fibonacciWithTabulation(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        long[] table = new long[n + 1];
        table[0] = 0;
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }


    private static Map<Integer, Long> fibMemo = new HashMap<>();

    public static void resetFibonacciMemo() {
        fibMemo.clear();
    }

    public static long fibonacciWithMemoization(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        // Check if already computed
        if (fibMemo.containsKey(n)) {
            return fibMemo.get(n);
        }
        // Compute and store
        long result = fibonacciWithMemoization(n - 1) + fibonacciWithMemoization(n - 2);
        fibMemo.put(n, result);
        return result;
    }

    /**
     * Calculates the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * Uses tabulation (bottom-up).
     * @param n The total number of steps in the staircase.
     * @return The number of distinct ways to climb the staircase.
     */
    public static int climbStairs(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of stairs cannot be negative.");
        }
        if (n == 0) {
            return 1; // One way to climb 0 stairs: do nothing
        }
        if (n == 1) {
            return 1; // One way to climb 1 stair: take 1 step
        }

        // dp[i] will be storing the number of ways to reach step i
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 1 way to be at step 0 (start)
        dp[1] = 1; // Base case: 1 way to reach step 1

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}