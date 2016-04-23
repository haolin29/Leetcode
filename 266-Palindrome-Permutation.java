public class Solution {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		int len = s.length();
		HashMap<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c,0);
			}
			map.put(c,map.get(c)+1);
		}
		int count = 0;
		for (char c:map.keySet()) {
			if (map.get(c) % 2 != 0) {
				count++;
			}
		}

		return count <= 1;
	}
}