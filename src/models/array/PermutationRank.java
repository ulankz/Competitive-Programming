package models.array;

public class PermutationRank {
	/**
	 * The above programs don’t work for duplicate characters. To make them work for
	 * duplicate characters, find all the characters that are smaller (include equal
	 * this time also), do the same as above but, this time divide the rank so
	 * formed by p! where p is the count of occurrences of the repeating character.
	 * The time complexity of the above solution is O(n^2)
	 */
	static int modulo = 1000003;

	public static int getPermutationRank(String A) {
		int length = A.length();
		int strFactorial;
		int rank = 1;
		for (int i = 0; i < length; i++) {
			strFactorial = Factorial(length - i - 1);
			// rank += (findSmallerInRight(A, i, (length - 1)) % modulo * strFactorial %
			// modulo) % modulo;
			rank += ((strFactorial % modulo) * (findSmallerInRight(A, i, length - 1) % modulo)) % modulo;
		}
		// System.out.println("Rank : " + rank);

		// rank %= modulo;
		return rank % modulo;
	}

	public static int Factorial(int n) {
		return (n <= 1 ? 1 : ((n % modulo) * (Factorial(n - 1) % modulo)) % modulo);
	}

	public static int findSmallerInRight(String A, int low, int high) {
		int countRight = 0;
		for (int i = low + 1; i <= high; i++) {
			if (A.charAt(i) < A.charAt(low))
				countRight++;
		}
		return countRight;
	}

}
