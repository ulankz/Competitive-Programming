package models.array;

public class PermutationRankFastest {
	static final int M = 1000003;

	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = (result % M * i) % M;
		}
		return result;
	}

	public int getRank(String A) {
		int n = A.length();
		if (n == 1)
			return 1;
		int sortedPosition = getSortedPosition(A);
		int posRank = (sortedPosition * factorial(n - 1)) % M;
		return (posRank + getRank(A.substring(1))) % M;
	}

	private int getSortedPosition(String A) {
		int rank = 0;
		for (int i = 1; i < A.length(); i++) {
			if (A.charAt(i) < A.charAt(0))
				rank++;
		}
		return rank;
	}

}
