package models.array;

public class ReverseString {
	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		char temp;
		int last;
		for (int i = 0; i < s.length() / 2; i++) {
			last = chars.length - i - 1;
			temp = chars[i];
			chars[i] = chars[last];
			chars[last] = temp;
		}
		return new String(chars);
	}
}
