package models.array;

import java.util.ArrayList;

public class PermutingListOfList {
	public static void permuteList(String[][] list, int start, ArrayList<String> perms) {
		if (start == list.length) {
			if (perms.size() == list.length) {
				System.out.println(perms.toString());
			}
			return;
		} else {
			for (int i = 0; i < list[start].length; i++) {
				perms.add(list[start][i]);
				for (int j = start + 1; j <= list.length; j++) {
					permuteList(list, j, perms);
				}
				perms.remove(list[start][i]);
			}
		}

	}

	public static void permute(String[][] list) {
		ArrayList<String> perms = new ArrayList<String>();
		permuteList(list, 0, perms);
	}
}
