public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null) {
            return true;
        }
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        
        for (int i = 0; i < s.length(); i++) {
            if(dp[i] != 0) {
                for(int j = i + 1; j <= s.length(); j++) {
                    if(wordDict.contains(s.substring(i,j))) {
                        dp[j] = 1;
                    }
                }
            }
        }
        
        return dp[s.length()] == 1;
    }
}