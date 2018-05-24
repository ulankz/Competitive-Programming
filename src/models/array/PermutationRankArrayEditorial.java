package models.array;

public class PermutationRankArrayEditorial {
	static final int M = 1000003;

	private int factorial(int n) {

		return (n <= 1 ? 1 : ((n % M) * (factorial(n - 1) % M)) % M);
	}

	public int getRank(String A) {
		int a[] = getFrequencies(A);
		int rank = 1;
		for (int i = 0; i < A.length(); i++) {
			int mul = factorial(A.length() - i - 1);
			// rank += ((mul % M) * (a[A.charAt(i) - 1] % M)) % M;
			rank += ((mul) * (a[A.charAt(i) - 1]));
			updateFrequency(a, A.charAt(i));
		}
		return rank % M;
	}

	// Removes a character ch from count[] array
	private static void updateFrequency(int a[], char ch) {
		for (int i = ch; i < 256; i++) {
			a[i]--;
		}
	}

	// Construct a count array where value at every index
	// contains count of smaller characters in whole string
	private static int[] getFrequencies(String s) {
		int a[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i)]++;
		}
		for (int i = 1; i < 256; i++) {
			a[i] += a[i - 1];
		}
		return a;
	}

	public int findRank(String A) {

		int result = 1;
		char ch[] = A.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			char a = ch[i];
			int countsmaller = 0;
			int fact = factorial(ch.length - 1 - i);
			for (int j = i + 1; j < ch.length; j++) {
				char b = ch[j];
				if (a > b) {
					countsmaller++;
				}
			}
			result = result + (fact * countsmaller);
		}
		return result % M;
	}

}
