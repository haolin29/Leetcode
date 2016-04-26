public class Solution {
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}
		int len = s.length;

		// reverse all char first
		reverse(s,0,len - 1)

		int start = 0;
		int end = -1;
		for (int i = 0; i < len; i++) {
			if (s[i] == ' ') {
				end = i - 1;
				reverse(s, start, end);
				start = i + 1;
			}
		}

		// reverse last word
		reverse(s, start, len - 1);
	}

	public void reverse(char[] s, int start, int end) {
		for (;start < end; start++, end--) {
			char c = s[start];
			s[start] = s[end];
			s[end] = c;
		}
	}
}