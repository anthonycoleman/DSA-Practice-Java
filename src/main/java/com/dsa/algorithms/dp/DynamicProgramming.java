package com.dsa.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    /**
     * Calculates the nth Fibonacci number using memoization (top-down).
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     */
    private static Map<Integer, Long> fibMemo = new HashMap<>();

    public static long fibonacci(int n) {
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
        long result = fibonacci(n - 1) + fibonacci(n - 2);
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

    /**
     * Solves the 0/1 knapsack problem using dynamic programming (tabulation).
     * Given weights and values of n items, put these items in a knapsack
     * of capacity W to get the maximum total value in the knapsack.
     * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
     * @param W The maximum capacity of the knapsack.
     * @param wt Array of weights of the items.
     * @param val Array of values of the items.
     * @param n The number of items.
     * @return The maximum value that can be put in a knapsack of capacity W.
     */
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        if (W < 0 || n < 0 || wt == null || val == null || wt.length != n || val.length != n) {
            throw new IllegalArgumentException("Invalid input for knapsack problem.");
        }
        if (W == 0 || n == 0) {
            return 0;
        }

        // dp[i][w] will be storing the maximum value that can be obtained
        // with first i items and knapsack capacity w.
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no items or no capacity
                } else if (wt[i - 1] <= w) {
                    // If weight of current item is less than or equal to current capacity w
                    // Two choices: include the item or exclude the item
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i - 1][w - wt[i - 1]], // Include item
                        dp[i - 1][w]                             // Exclude item
                    );
                } else {
                    // If weight of current item is more than current capacity w,
                    // then this item cannot be included
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
}
