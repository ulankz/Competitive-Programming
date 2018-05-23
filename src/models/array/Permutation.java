package models.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
	List<String> list = new ArrayList<>();

	public String getPermutation(int n, int k) {
		String suffix = "";
		for (int i = 1; i <= n; i++) {
			suffix += i;
		}

		permutation_v0(suffix, "");
		return list.get(k - 1);
	}

	private void permutation_v0(String suffix, String prefix) {

		if (suffix.length() == 0) {
			list.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				String rem = suffix.substring(0, i) + suffix.substring(i + 1);
				permutation_v0(rem, prefix + suffix.charAt(i));
			}
		}
	}

	public static void getPermutation_v1(String s) { // Permutations are IN ORDER
		getPermutation_v1(s, "");
	}

	private static void getPermutation_v1(String suffix, String prefix) {
		int n = suffix.length();
		if (n == 0) {
			System.out.print(prefix + " ");
		} else {
			for (int i = 0; i < n; i++) {
				getPermutation_v1(suffix.substring(0, i) + suffix.substring(i + 1), prefix + suffix.charAt(i));
			}
		}
	}

	public static void getPermutation_v2(String s) {
		int n = s.length();
		char[] a = s.toCharArray();
		getPermutation_v2(a, 0, n);
	}

	private static void getPermutation_v2(char[] a, int end) { // Permutations are NOT IN ORDER

		if (end == 1) {
			System.out.print(new String(a) + " ");
			return;
		} else {
			for (int i = 0; i < end; i++) {
				swap(a, i, end - 1);
				getPermutation_v2(a, end - 1);
				swap(a, i, end - 1);
			}
		}
	}

	/**
	 * O(n*n!) Note that there are n! permutations and it requires O(n) time to
	 * print a a permutation. The above solution prints duplicate permutations if
	 * there are repeating characters in input string.
	 */
	private static void getPermutation_v2(char[] a, int start, int end) { // Permutations are IN ORDER

		if (start == end) {
			System.out.print(new String(a) + " ");
		} else {
			for (int i = start; i < end; i++) {
				swap(a, start, i);
				getPermutation_v2(a, start + 1, end);
				swap(a, start, i);
			}
		}
	}

	private static void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	
    }
