package com.dsa.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DynamicProgramming {

    // Purely recursive Fibonacci (can be slow for large n)
    public static long fibonacciRecursive(int n) {
        // TODO: Implement the naive recursive solution.
        // This is inefficient and has a time complexity of O(2^n).
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        // Handle base cases (e.g., n <= 1).
        return -1; // Placeholder for long
    }

    // Fibonacci with Tabulation (Bottom-Up DP)
    public static long fibonacciWithTabulation(int n) {
        // TODO: Implement the tabulated (bottom-up) solution.
        // This is efficient, with a time complexity of O(n) and O(n) space.
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        // You will need an array or list to store Fibonacci numbers from 0 to n.
        // Handle base cases (e.g., n <= 1).
        return -1; // Placeholder for long
    }


    private static Map<Integer, Long> fibMemo = new HashMap<>();

    public static void resetFibonacciMemo() {
        fibMemo.clear();
    }

    public static long fibonacciWithMemoization(int n) {
        // TODO: Implement the memoized (top-down) solution.
        // This is efficient, with a time complexity of O(n).
        // Remember to use fibMemo and resetFibonacciMemo() appropriately.
        if (n < 0) {
            throw new IllegalArgumentException("Input n cannot be negative.");
        }
        // Handle base cases (e.g., n <= 1).
        // Check fibMemo, compute if not present, store, then return.
        return -1; // Placeholder for long
    }

    /**
     * Calculates the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * Uses tabulation (bottom-up).
     * @param n The total number of steps in the staircase.
     * @return The number of distinct ways to climb the staircase.
     */
    public static int climbStairs(int n) {
        // TODO: Implement the climbStairs solution.
        // You can use tabulation (bottom-up DP).
        if (n < 0) {
            throw new IllegalArgumentException("Number of stairs cannot be negative.");
        }
        // Handle base cases (e.g., n == 0, n == 1).
        return 0; // Placeholder for int
    }

}