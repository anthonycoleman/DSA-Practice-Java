package com.dsa.algorithms.dynamicprogramming;

/**
 * A collection of classic Dynamic Programming problems.
 */
public class DynamicProgramming {

    /**
     * Calculates the nth Fibonacci number using a naive recursive approach.
     * This is inefficient and has a time complexity of O(2^n).
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     */
    public long fibonacciRecursive(int n) {
        // TODO: Implement the naive recursive solution.
        return -1;
    }

    /**
     * Calculates the nth Fibonacci number using recursion with memoization (top-down DP).
     * This is efficient, with a time complexity of O(n).
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     */
    public long fibonacciWithMemoization(int n) {
        // TODO: Implement the memoized (top-down) solution.
        // You will need a helper method and a cache (e.g., a long[] or Map).
        return -1;
    }

    /**
     * Calculates the nth Fibonacci number using tabulation (bottom-up DP).
     * This is also efficient, with a time complexity of O(n) and O(n) space.
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     */
    public long fibonacciWithTabulation(int n) {
        // TODO: Implement the tabulated (bottom-up) solution.
        // You will need an array or list to store Fibonacci numbers from 0 to n.
        return -1;
    }
}
