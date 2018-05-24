package models.array;

public class PermutationRankArrayFastest {
	static final int M = 1000003;
	int factorials[];

	private void factorials(int n) {
		factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorials[i] = (factorials[i - 1] % M * i) % M;
		}
	}

	public int getRank(String A) {
		int n = A.length();
		if (n == 1)
			return 1;
		factorials(n);
		int[] chars = new int[256];
		for (int i = 0; i < A.length(); i++) {
			byte c = (byte) A.charAt(i);
			chars[c]++;
		}
		int rank = 1;
		for (int i = 0; i < n; i++) {
			int lessCount = 0;
			for (int j = 0; j < (byte) A.charAt(i); j++) {
				lessCount += chars[j];
			}
			rank += factorials[n - i - 1] * lessCount % M;
			chars[A.charAt(i)] = 0;
		}
		return rank % M;
	}

}
