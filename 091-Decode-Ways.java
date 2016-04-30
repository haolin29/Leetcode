public class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		// 定义dp[i+1]为能解码长度为i+1的string s[0:i]的方法数
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) != '0' ? 1 : 0;

		for (int i = 2; i <= n; i++) {
			int one = Integer.valueOf(s.substring(i - 1, i));
			int two = Integer.valueOf(s.substring(i - 2, i));
			if (one > 0 && one < 10) {
				dp[i] += dp[i - 1];
			}
			if (two <= 26 && two >= 10) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[n];

	}
}