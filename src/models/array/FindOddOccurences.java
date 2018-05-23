package models.array;

import java.util.HashMap;

public class FindOddOccurences {
	public int get_odd_occurences_brute_force(int[] a) { // O(n*n) space complexity is O(1)
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					count++;
				}

			}
			if (count % 2 != 0)
				return a[i];
		}
		return -1;
	}

	public int get_odd_occurences_optimal_v1(int[] a) { // Time complexity O(n) space complexity is O(n)
		HashMap<Integer, Integer> hashSet = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (hashSet.containsKey(a[i])) {
				hashSet.put(a[i], hashSet.get(a[i]) + 1);
			} else {
				hashSet.put(a[i], 1);
			}
		}
		for (Integer i : hashSet.keySet()) {
			if (hashSet.get(i) % 2 != 0) {
				return i;
			}
		}
		return -1;
	}

	public int get_odd_occurences_optimal_v2(int[] a) { // Time complexity O(n) space complexity is O(1)
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result ^= i;
		}
		return result;
	}
}
