package models.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPermutation {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> listOutput = new ArrayList<ArrayList<Integer>>();
		permuteList(A, 0, listOutput);
		return listOutput;
	}

	public static void printList(List<List<Integer>> lists) {
		for (List<Integer> list : lists) {
			for (Integer i : list)
				System.out.print(i);
			System.out.print(" ");
		}

	}

	public static void printList(ArrayList<ArrayList<Integer>> lists) {
		for (ArrayList<Integer> list : lists) {
			for (Integer i : list)
				System.out.print(i);
			System.out.print(" ");
		}

	}

	public void permuteList(ArrayList<Integer> arrayList, int element, ArrayList<ArrayList<Integer>> listsInput) {
		int i = 0;
		for (i = element; i < arrayList.size(); i++) {
			Collections.swap(arrayList, i, element);
			permuteList(arrayList, element + 1, listsInput);
			Collections.swap(arrayList, i, element);
		}
		if (element == arrayList.size() - 1) {
			if (!listsInput.contains(arrayList))
				listsInput.add(new ArrayList<>(arrayList));
			// System.out.println(Arrays.toString(arrayList.toArray()));
		}
	}

	public List<List<Integer>> permute_v1(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> pList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			pList.add(nums[i]);
		}
		permuteHelper(pList, 0, lists);
		return lists;
	}

	private void permuteHelper(List<Integer> pList, int start, List<List<Integer>> lists) {
		int l = pList.size();
		if (start == l - 1) {
			if (!lists.contains(pList))
				lists.add(new ArrayList<>(pList));
		}
		for (int i = start; i < l; i++) {
			Collections.swap(pList, start, i);
			permuteHelper(pList, start + 1, lists);
			Collections.swap(pList, start, i);
		}
	}
}
