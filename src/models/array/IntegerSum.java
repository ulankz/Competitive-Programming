package models.array;

public class IntegerSum {
	/**
	 * Time complexity is O(n*n) Space complexity is O(1)
	 */
	public int getSum_brute_force(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				result += 1;
			}
		}
		return result;
	}

	/**
	 * Time complexity is O(n*n) Space complexity is O(1)
	 */
	public int getSum_optimal_v1(int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += i + 1;
		}
		return result;
	}

	/**
	 * Time complexity is O(1) SpaceComplexity O(1)
	 */
	public int getSum_optimal_v2(int n) {

		return (n * (n + 1) / 2);
	}
}
