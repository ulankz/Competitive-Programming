package models;

import java.math.BigInteger;

public class Factorial {
	/**
	 * Iterative solution for this problem. This version is based on the factorial
	 * definition described in the statement and the complexity order in time terms
	 * of this solution is O(N) where N is integer passed as argument. In space
	 * terms, the complexity order of this algorithm is O(1) because we are not
	 * using any additional data structure related to the integer passed as
	 * parameter.Only int numbers which fits 4 bytes will be displayed Space
	 */
	public int get_factorial(int n) {
		validateInput(n);
		int factorial = 1;
		for (int i = 2; i < n + 1; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public BigInteger get_factorial_big(int n) {// Runtime is O(n)
		validateInput(n);
		BigInteger fact = BigInteger.valueOf(1L);
		for (int i = 2; i < n + 1; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	/**
	 * Recursive implementation of the previous algorithm. The complexity order in
	 * time and space terms is the same. Take into account that this implementation
	 * is not tail recursive.Time complexity is O(n) and auxiliary space used by the
	 * program is O(n) for call stack.Auxiliary Space is the extra space or
	 * temporary space used by an algorithm.
	 * 
	 */
	public int get_factorial_rec(int n) { // Recursion is costly for large numbers
		validateInput(n);
		return (n == 0) || n == 1 ? 1 : n * get_factorial_rec(n - 1);
	}

	public void validateInput(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative numbers factorial is not defined.");
	}

	/**
	 * Tail recursive implementation of the previous algorithm. The complexity order
	 * in time and space terms is the same but the resources needed by the CPU to
	 * execute this method is lower because this implementation is tail recursive.
	 * 
	 * public int getTailRecursive(int n) { validateInput(n); return
	 * getTailRecursiveInner(n, 1); }
	 * 
	 * private int getTailRecursiveInner(int n, int acc) { if (n == 0) { return acc;
	 * } else { return getTailRecursiveInner(n - 1, acc * n); } }
	 */
}
