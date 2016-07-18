public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int n1 = s.length();
        int n2 = p.length();
        
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        
        //init
        dp[0][0] = true;
        
        for(int i = 1; i <= n1; i++) {
            dp[i][0] = false;
        }
        
        for(int j = 1; j <= n2; j++) {
            dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
        }
        
        // transfer function
        for (int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                } else {
                    dp[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[n1][n2];
    }
}