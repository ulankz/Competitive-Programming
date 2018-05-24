package models.array;

import java.util.Arrays;

public class PermutationRankLightWeight {
	static final int M = 1000003;

	private int factorial(int n) {
		if (n <= 1)
			return 1;
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = (result % M * i) % M;
		}
		return result;
	}

	public int getRank(String A) {
		char[] chars = A.toCharArray();
		Arrays.sort(chars);

		boolean[] marked = new boolean[A.length()];
		return getRank(chars, A, 0, marked) % M;
	}

	private int getRank(char[] chars, String a, int index, boolean[] marked) {
		if (index == chars.length - 1)
			return 1;
		char c = a.charAt(index);
		int smallerCharsCount = 0;
		int rank = 0;
		char cd = chars[0];
		for (int i = 0; i < marked.length && c >= chars[i]; i++) {
			if (!marked[i]) {
				if (chars[i] == c) {
					marked[i] = true;
					break;
				}
				smallerCharsCount++;
			}

		}
		rank = (smallerCharsCount * factorial(a.length() - 1 - index)) % M;
		return rank + getRank(chars, a, ++index, marked);

	}

}
