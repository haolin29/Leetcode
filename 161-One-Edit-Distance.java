public class Solution {
	public boolean isOneEditDistance(String s, String t) {

		if (Math.abs(s.length() - t.length()) > 1) return false;
		if (s.length() == t.length()) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					count++;
				}
			}
			return count == 1;
		} 

		if (s.length() > t.length()) {
			return isOneHelper(s,t);
		} else {
			return isOneHelper(t,s);
		}


	}

	public boolean isOneHelper(String s, String t) {
		for (int i = 0,j = 0; i < s.length() && j < t.length(); i++, j++) {
			if (s.charAt(i) != t.charAt(j)) {
				return s.substring(i + 1).equals(t.substring(j));
			}
		}

		return true;
	}
}