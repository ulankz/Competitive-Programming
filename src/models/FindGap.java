package models;

public class FindGap {

	public int Find_Gap(int n) {
		int zeroCount = 0;
		int maxZeros = 0;
		boolean firstOne = false;
		while (n > 0) {
			if ((n & 1) == 1) {
				if (!firstOne) {
					firstOne = true;
				}
				zeroCount = 0;
			} else if ((n & 1) == 0) {
				if (firstOne) {
					zeroCount++;
				}
				if (zeroCount > maxZeros) {
					maxZeros = zeroCount;

				}
			}

			n = n >> 1;
		}
		return maxZeros;
	}

}
