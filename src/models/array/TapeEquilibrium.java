package models.array;

public class TapeEquilibrium {
	public int getEquilibrium_brute_force(int[] A) {
		int curDiff = 0, minDiff = Integer.MAX_VALUE, fSum = 0, sSum = 0;
		int n = A.length;

		for (int p = 1; p <= n - 1; p++) {
			for (int i = 0; i <= p - 1; i++) {
				fSum += A[i];

			}
			// System.out.println(fSum + " FirstHalf > " + p);
			for (int i = p; i <= n - 1; i++) {
				sSum += A[i];

			}
			// System.out.println(sSum + " SecondHalf > " + p);
			curDiff = Math.abs(fSum - sSum);
			if (curDiff < minDiff) {
				minDiff = curDiff;
			}
			fSum = 0;
			sSum = 0;
		}
		curDiff = 0;
		return minDiff;
	}

	public int getEquilibrium_optimal(int[] A) {
		int curDiff = 0, minDiff = Integer.MAX_VALUE, fSum = 0, sSum = 0;
		int n = A.length;

		for (int i = 0; i < n; i++) {
			sSum += A[i];
		}

		for (int p = 1; p < n; p++) {

			fSum += A[p - 1];
			sSum -= A[p - 1];
			curDiff = Math.abs(fSum - sSum);
			if (curDiff < minDiff) {
				minDiff = curDiff;
			}
		}
		return minDiff;
	}
}
