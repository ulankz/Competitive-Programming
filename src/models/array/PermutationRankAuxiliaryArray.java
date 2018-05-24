package models.array;

public class PermutationRankAuxiliaryArray {
	/**
	 * The above programs don’t work for duplicate characters. To make them work for
	 * duplicate characters, find all the characters that are smaller (include equal
	 * this time also), do the same as above but, this time divide the rank so
	 * formed by p! where p is the count of occurrences of the repeating character.
	 * The time complexity of the above solution is O(n) by creating an auxiliary
	 * array of size 256
	 */
	static int M = 1000003;

	public int getPermutationRank(String A) {
		int length = A.length();
		int mul;
		int rank = 1;
		// Populate the array such that a[i]
		// contains count of characters which are present
		// in A and are smaller than i
		int a[] = populateAndIncreaseCount(A);
		for (int i = 0; i < length; i++) {
			mul = factorial(length - i - 1);
			// count number of chars smaller than str[i]
			// fron str[i+1] to str[len-1]
			rank += ((mul) * (a[A.charAt(i) - 1]));
			updateCount(a, A.charAt(i));
		}
		return rank % M;
	}

	// A utility function to find factorial of n
	public static int factorial(int n) {
		return (n <= 1 ? 1 : ((n % M) * (factorial(n - 1) % M)) % M);
	}

	// Construct a count array where value at every index
	// contains count of smaller characters in whole string
	private static int[] populateAndIncreaseCount(String s) {

		int a[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i)]++;
		}
		for (int i = 1; i < 256; i++) {
			a[i] += a[i - 1];
		}
		return a;
	}

	// Removes a character ch from count[] array
	private static void updateCount(int a[], char ch) {
		for (int i = ch; i < 256; i++) {
			a[i]--;
		}
	}

}
