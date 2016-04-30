public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}

		int len = s.length();
		boolean[] dp = new boolean[len + 1]; // if can be cut before i elements	
		dp[0] = true;
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (wordDict.contains(s.substring(j,i)) && dp[j]) {
					dp[i] = true;
				} 
			}
		}

		return dp[len];

	}
}