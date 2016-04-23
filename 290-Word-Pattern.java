public class Solution {
	public boolean wordPattern(String pattern, String str) {
		if(str == null || str.length() == 0) {
			return false;
		}

		String[] strs = str.split(" ");
		if (pattern.length() != strs.length) return false;
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, strs[i]);
				if (map.containsValue(strs[i])) {
					return false;
				}
			} else {
				if (!map.get(c).equals(strs[i])) {
					return false;
				}
			}


		}

		return true;
	}
}