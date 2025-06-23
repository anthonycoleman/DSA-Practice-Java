package com.dsa.algorithms.dp;

/**
 * Fibonacci with Tabulation Implementation (Bottom-Up Dynamic Programming)
 * 
 * Time Complexity: O(n) - single pass through the sequence
 * Space Complexity: O(1) - only stores the last two values
 * 
 * Tabulation is a bottom-up approach that starts with the smallest subproblems
 * and builds up to the solution. This implementation is optimized to use only
 * constant space by keeping track of just the previous two Fibonacci numbers.
 * 
 * This is typically the most efficient approach for Fibonacci calculation
 * in terms of both time and space complexity.
 * 
 * Test this implementation:
 * ./gradlew test --tests "FibonacciTabulationTest"
 * ./gradlew test --tests "com.dsa.algorithms.dp.FibonacciTabulationTest"
 * ./gradlew test --tests "*FibonacciTabulation*"
 * ./gradlew test --tests "*Tabulation*"
 */
public class FibonacciTabulation {
    
    /**
     * Calculates the nth Fibonacci number using tabulation (bottom-up DP)
     * @param n the position in the Fibonacci sequence (0-indexed)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
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