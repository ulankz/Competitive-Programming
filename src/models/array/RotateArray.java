package models.array;

public class RotateArray {
	public int[] rotate_by_one(int[] a) {
		int i = 0;
		int l = a.length;
		int last = a[l - 1];
		for (i = l - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[i] = last;
		return a;
	}

	/**
	 * Time complexity : O(n * d). Auxiliary Space : O(1)
	 */
	public int[] rotate_by_one_k_steps(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			rotate_by_one(a);
		}
		return a;
	}

	/**
	 * Complexity Analysis Time complexity : O(n*k). All the numbers are shifted by
	 * one step(O(n)) k times(O(k)). Space complexity : O(1). No extra space is
	 * used.
	 */
	public int[] rotate_by_k_steps_brute_force(int[] a, int k) {
		int temp;
		int previous;
		int l = a.length;
		if (l > 0)
			for (int i = 0; i < k; i++) {
				previous = a[l - 1];
				for (int j = 0; j < l; j++) {
					temp = a[j];
					a[j] = previous;
					previous = temp;
				}
			}
		return a;
	}

	/**
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). One pass is used to put the numbers in the new array.
	 * And another pass to copy the new array to the original one.
	 * 
	 * Space complexity : O(n). Another array of the same size is used.
	 */

	public int[] rotate_by_k_steps_extra_array(int[] a, int k) {
		int l = a.length;
		k = k % l;
		int[] extra = new int[l];
		for (int i = 0; i < l; i++) {
			extra[(i + k) % l] = a[i];
		}
		for (int i = 0; i < l; i++) {
			a[i] = extra[i];
		}
		return a;
	}

	/**
	 * Complexity Analysis
	 * 
	 * Time complexity : O(n). n elements are reversed a total of three times.
	 * 
	 * Space complexity : O(1). No extra space is used.
	 */
	public int[] rotate_by_k_steps_using_reverse(int[] a, int k) {
		int l = a.length;
		k = k % l;
		reverse(a, 0, l - 1);
		reverse(a, 0, k - 1);
		reverse(a, k, l - 1);
		return a;
	}

	private void reverse(int[] a, int start, int end) {
		for (int i = start; i < end; i++, end--) {
			int temp = a[i];
			a[i] = a[end];
			a[end] = temp;
		}
	}
}