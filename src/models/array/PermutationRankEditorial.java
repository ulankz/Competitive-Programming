package models.array;

public class PermutationRankEditorial {
	static final int M = 1000003;
	int[] factorials;

	void fillFactorials(int n) {
		factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorials[i] = (factorials[i - 1] * i) % M;
		}
	}

	public int getRank(String A) {
		int n = A.length();
		fillFactorials(n);
		int[] chars = new int[256];
		for (int i = 0; i < n; i++) {
			byte c = (byte) A.charAt(i);
			// System.out.print(c + " ");
			chars[c]++;
		}
		int rank = 1;
		for (int i = 0; i < n; i++) {
			int lessThan = 0;
			for (int j = 0; j < (byte) A.charAt(i); j++) {
				lessThan += chars[j];
			}
			rank += factorials[n - i - 1] * lessThan % M;
			chars[A.charAt(i)] = 0;
		}
		return rank % M;
	}
}
