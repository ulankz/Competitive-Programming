package models.array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Remember that the total number of permutations of { n} items is given by {
 * n!} which grows large very quickly: A 32 bit integer can only hold { 12!} , a
 * 64 bit integer only { 20!} . It becomes difficult to take the
 * straight-forward approach of generating all permutations then taking a random
 * sample of them.
 * 
 * @author Ulan
 *
 */
public class KthPermutationSequence {
	public String getKthPermutation(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		int[] fact = new int[n];//// [1,1,2]
		fact[0] = 1;
		for (int i = 1; i < n; i++) {
			fact[i] = i * fact[i - 1];
		}

		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}
		k--;
		String result = "";
		for (int i = n - 1; i >= 0; i--) {
			int index = k / fact[i];
			// System.out.println("Index "+" "+index);
			result = result + list.remove(index);
			// System.out.println("Result " + result);
			k = k % fact[i];
			// System.out.println("K "+ k);

		}
		return result;
		// System.out.println("Result " + result);
	}

	public static String findPermutation(int n, int k) {
		int[] numbers = new int[n];
		int[] indices = new int[n];
		String result = "";
		// initialise the numbers 1, 2, 3...
		for (int i = 0; i < n; i++) {
			numbers[i] = i + 1;
		}
		int divisor = 1;
		k--;
		for (int place = 1; place <= n; place++) {
			if (k / divisor == 0) {
				break; // all the remaining indices will be zero
			}
			// compute the index at that place:
			indices[n - place] = (k / divisor) % place;
			divisor *= place;
		}
		// print out the indices:
		// System.out.println(Arrays.toString(indices));
		// permute the numbers array according to the indices:
		for (int i = 0; i < n; i++) {
			int index = indices[i] + i;
			// take the element at index and place it at i, moving the rest up
			if (index != i) {
				int temp = numbers[index];
				for (int j = index; j > i; j--) {
					numbers[j] = numbers[j - 1];
				}
				numbers[i] = temp;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}
		return result;
	}

	public static String getPermutationEditorial(int A, int B) {
		ArrayList<Integer> candidateList = new ArrayList<>();
		for (int i = 0; i < A; i++) {
			candidateList.add(i + 1);
		}
		return getPermutationEditorial(B - 1, candidateList);
	}

	private static String getPermutationEditorial(int k, ArrayList<Integer> candidateList) {
		int n = candidateList.size();
		if (n == 0)
			return "";
		if (k > factorial(n))
			return "";// invalid. Should never reach here
		int f = factorial(n - 1);
		int pos = k / f;
		k %= f;
		String ch = String.valueOf(candidateList.get(pos));
		// now remove the character ch from candidateList
		candidateList.remove(pos);
		return ch + getPermutationEditorial(k, candidateList);
	}

	public static String getPermutationFastest(int n, int k) {
		if (k > factorial(n))
			return "";
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			list.add(i);
		return getPermutationFastest(list, k - 1);
	}

	private static String getPermutationFastest(ArrayList<Integer> list, int k) {
		int n = list.size();
		if (n == 0)
			return "";
		int fact_n = factorial(n - 1);
		int index = k / fact_n;
		int num = list.get(index);
		list.remove(index);
		k %= fact_n;
		return num + getPermutationFastest(list, k);
	}

	static int factorial(int n) {
		if (n > 12)
			// this overflows in int. So, its definitely greater than k which is all we care
			// about.So, we return INT_MAX
			// which is also greater than k;
			return Integer.MAX_VALUE;
		// Can also store these values. But this is just < 12 iteration, so meh!
		int fact = 1;
		for (int i = 2; i <= n; i++)
			fact *= i;
		return fact;
	}

	public static String getPermutationLightWeight(int n, int k) {
		int idx = 1;
		for (idx = 1; idx <= n; idx++) {
			if (factorial(idx) >= k)
				break;
		}
		StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= n - idx; i++) {
			ans.append(i);
		}
		ArrayList<Integer> list = new ArrayList<>(n);
		for (int i = 1; i <= idx; i++) {
			list.add(i);
		}
		for (int i = 1; i <= idx; i++) {
			int index = (k - 1) / factorial(idx - i);
			ans.append(list.get(index) + (n - idx));
			list.remove(index);
			k = (k - index * (factorial(idx - i)));
		}
		return ans.toString();
	}

	static long factorial_long(int n) {
		int f = 1;
		for (int i = 2; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	public static String getPermutationLightWeight_v1(int n, int k) {
		int index = k;
		StringBuilder ans = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		k--;
		for (int i = 1; i <= n; i++) {
			index = k / factorial(n - i);
			ans.append(list.get(index));
			list.remove(index);
			k = k - index * factorial(n - i);
		}
		return ans.toString();
	}

	public static String getPermutationArrayLightWeight(int n, int k) {
		k--;
		int[] indices = new int[n];
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		int divisor = 1;
		for (int place = 1; place <= n; place++) {
			if (k / divisor == 0) {
				break; // all remaining indices will be zero
			}
			// compute the index at that place
			indices[n - place] = (k / divisor) % place;
			divisor *= place;
		}
		// print out the indices
		System.out.println(Arrays.toString(indices));
		// Permute the numbers array according to the indices
		for (int i = 0; i < n; i++) {
			int index = indices[i] + i;
			// take the element at index and place it at i, moving the rest up
			if (index != i) {
				int temp = nums[index];

				for (int j = index; j > i; j--) {
					nums[j] = nums[j - 1];
				}
				nums[i] = temp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	public static String getPermutationArrayFastest(int n, int k) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		// Create a list of numbers to get indices
		for (int i = 0; i < n; i++) {
			list.add(i + 1);
		}

		k--;
		int fact = 1;
		int index = 0;
		for (int i = 1; i <= n; i++) {
			fact = factorial_bigInteger(n - i).intValue();
			index = 0;
			if (fact > 0)
				index = k / fact;
			sb.append(String.valueOf(list.get(index)));
			list.remove(index);
			k -= index * fact;
		}
		return String.valueOf(sb);
	}

	private static BigInteger factorial_bigInteger(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value must be positive");
		}
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= value; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
