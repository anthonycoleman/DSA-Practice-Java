package com.dsa.algorithms.dp;

/**
 * Recursive Fibonacci Implementation (Naive Approach)
 * 
 * Time Complexity: O(2^n) - exponential time due to repeated calculations
 * Space Complexity: O(n) - due to recursion call stack
 * 
 * This is the most straightforward implementation of Fibonacci using recursion,
 * directly following the mathematical definition: F(n) = F(n-1) + F(n-2)
 * 
 * While simple to understand, this approach is inefficient for large values of n
 * due to redundant calculations of the same subproblems.
 * 
 * Test this implementation:
 * ./gradlew test --tests "FibonacciRecursiveTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciRecursiveTest"
 * ./gradlew test --tests "*FibonacciRecursive*"
 */
public class FibonacciRecursive {
    
    /**
     * Calculates the nth Fibonacci number using naive recursion
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static long fibonacciRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 1) return n;
        
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}