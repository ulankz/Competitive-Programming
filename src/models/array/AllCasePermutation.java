package models.array;

import java.util.HashSet;
import java.util.Set;

public class AllCasePermutation {
	public static void allCasePermutation(String str, int start, Set<String> res) {
		if (start == str.length()) {
			res.add(str);
			return;
		}

		char[] chars = str.toCharArray();
		chars[start] = Character.toLowerCase(chars[start]);
		allCasePermutation(new String(chars), start + 1, res);
		chars[start] = Character.toUpperCase(chars[start]);
		allCasePermutation(new String(chars), start + 1, res);
	}

	public static void permute(String str) {
		Set<String> res = new HashSet<String>();
		allCasePermutation(str, 0, res);
		System.out.println(res.toString());
	}
}
