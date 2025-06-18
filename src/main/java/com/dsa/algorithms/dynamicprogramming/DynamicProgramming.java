package com.dsa.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    // Purely recursive Fibonacci (can be slow for large n)
    public static long fibonacciRecursive(int n) {
        // TODO: Implement the naive recursive Fibonacci solution.
        // Base cases: fib(0) = 0, fib(1) = 1.
        // Recursive step: fib(n) = fib(n-1) + fib(n-2).
        // Handle n < 0 with an IllegalArgumentException.
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n; // Placeholder, actual base case
        }
        return 0; // Placeholder for recursive call result
    }

    // Fibonacci with Tabulation (Bottom-Up DP)
    public static long fibonacciWithTabulation(int n) {
        // TODO: Implement Fibonacci using tabulation (bottom-up DP).
        // Create a table to store Fibonacci numbers up to n.
        // Base cases: table[0] = 0, table[1] = 1.
        // Fill the table: table[i] = table[i-1] + table[i-2].
        // Handle n < 0 with an IllegalArgumentException.
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n; // Placeholder, actual base case
        }
        return 0; // Placeholder
    }


    // private static Map<Integer, Long> fibMemo = new HashMap<>(); // Used in full solution

    public static void resetFibonacciMemo() {
        // TODO: (Optional) Implement if you use a static memoization table that needs resetting for tests.
        // fibMemo.clear(); // Used in full solution
    }

    public static long fibonacciWithMemoization(int n) {
        // TODO: Implement Fibonacci using memoization (top-down DP).
        // Use a map or array to store results of subproblems.
        // Base cases: fib(0) = 0, fib(1) = 1.
        // If result for n is in memo, return it.
        // Otherwise, compute fib(n-1) + fib(n-2), store in memo, then return.
        // Handle n < 0 with an IllegalArgumentException.
        // Consider how the memoization cache is managed (e.g., passed as parameter, or static with a reset method).
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        if (n <= 1) {
            return n; // Placeholder, actual base case
        }
        return 0; // Placeholder
    }

    /**
     * Calculates the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * Uses tabulation (bottom-up).
     * @param n The total number of steps in the staircase.
     * @return The number of distinct ways to climb the staircase.
     */
    public static int climbStairs(int n) {
        // TODO: Implement the climbStairs problem using tabulation.
        // You can climb 1 or 2 steps at a time.
        // dp[i] = number of ways to reach step i.
        // Base cases: dp[0] = 1 (one way to be at the start - do nothing), dp[1] = 1 (one way to reach step 1).
        // Recurrence: dp[i] = dp[i-1] + dp[i-2].
        // Handle n < 0 with an IllegalArgumentException.
        if (n < 0) {
            throw new IllegalArgumentException("Number of stairs cannot be negative.");
        }
        if (n == 0) {
            return 1; // Placeholder, actual base case
        }
        if (n == 1) {
            return 1; // Placeholder, actual base case
        }
        return 0; // Placeholder
    }

}