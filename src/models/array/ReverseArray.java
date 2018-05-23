package models.array;

public class ReverseArray {
	public int[] reverseArrayTemporaryHalf(int[] a) {
		int l = a.length;
		int lastIndex = 0;
		int temp;
		for (int i = 0; i < l / 2; i++) { // Time complexity O(n)
			lastIndex = l - i - 1;
			temp = a[i];
			a[i] = a[lastIndex];
			a[lastIndex] = temp;
		}
		return a;
	}

	public int[] reverseArrayTemporaryHalfXor(int[] a) {
		int l = a.length;
		int lastIndex = 0;
		int left;
		int right;
		for (int i = 0; i < l / 2; i++) { // Time complexity O(n)
			lastIndex = l - i - 1;
			left = a[i];
			right = a[lastIndex];
			left ^= right;
			right ^= left;
			left ^= right;

			a[i] = left;
			a[lastIndex] = right;
		}
		return a;
	}
}
