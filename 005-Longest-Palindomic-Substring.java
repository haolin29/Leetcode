public class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		dp[0][0] = true;
		String result = "";

		for(int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}

				if (dp[i][j] && j - i + 1 > result.length()) {
					result = s.substring(i,j + 1);
				}
			}
		}

		return result;

	}
}