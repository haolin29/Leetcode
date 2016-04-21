public class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String, List<String>> map = new HashMap<>();

		if (strings == null || strings.length() == 0) {
			return res;
		}

		for (String str: strings) {
			int offset = str.charAt(0) - 'a';
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = (char)(str.charAt(i) - offset);
				if (c < 'a') {
					c += 26；
				}

				sb.append(c);
			}
			String s = sb.toString();
			if (!map.containsKey(s)) {
				List<String> list = new ArrayList<>();
				map.put(s,list);
			}

			map.get(s).add(str);

		}


		for(String key: map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			res.add(list);
		}

		return res;
	}
}