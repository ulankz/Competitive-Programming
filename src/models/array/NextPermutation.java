package models.array;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
	/**
	 * Observe that if all the digits are in non-decreasing order from right to left
	 * then the input itself is the biggest permutation of its digits. So, if we can
	 * detect the position where the non-decreasing sequence in disrupted then we
	 * can simply work on the part of the digits. We can do it in O(n) using the
	 * following algorithm:
	 * 
	 * 1.Find the largest index k such that nums[k] < nums[k+1] 2.If no such index
	 * exists, the permutation is sorted in descending order, just reverse it to
	 * ascending order and we are done. For example, the next permutation of [3, 2,
	 * 1] is [1, 2, 3]. 3.Find the largest index l greater than k such that nums[k]
	 * < nums[l]. 4.Swap the value of nums[k] with nums[l] 5.Reverse the sequence
	 * from nums[k+1] up to and including the final element nums[nums.size() - 1]
	 */
	public static void get_nextPermutation(int[] nums) {
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}
		if (k == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int l = -1;
		for (int i = nums.length - 1; i > k; i--) {
			if (nums[i] > nums[k]) {
				l = i;
				break;
			}
		}
		swap(nums, k, l);
		reverse(nums, k + 1, nums.length - 1);
	}

	private static void reverse(int[] A, int i, int j) {
		while (i < j) {
			swap(A, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

	}

	public static void get_nextPermutation(ArrayList<Integer> a) {
		int k = -1;

		for (int i = a.size() - 2; i >= 0; i--) {
			if (a.get(i) < a.get(i + 1)) {
				k = i;
				break;
			}
		}
		if (k == -1) {

			Collections.sort(a);

			return;
		}
		int l = -1;
		for (int i = a.size() - 1; i > k; i--) {
			if (a.get(i) > a.get(k)) {
				l = i;
				break;
			}
		}
		Collections.swap(a, k, l);
		// reverse(a, k + 1, a.size() - 1);
		Collections.reverse(a.subList(k + 1, a.size()));
	}

	public static void get_nextPermutationEditorial(ArrayList<Integer> a) {
		int k = a.size() - 2;
		while (k >= 0 && a.get(k) >= a.get(k + 1))
			k--;
		if (k < 0) {
			Collections.sort(a);
			return;
		}
		for (int i = a.size() - 1; i >= 0; i--) {
			if (a.get(i) > a.get(k)) {
				Collections.swap(a, i, k);
				break;
			}
		}
		Collections.reverse(a.subList(k + 1, a.size()));

	}
}
