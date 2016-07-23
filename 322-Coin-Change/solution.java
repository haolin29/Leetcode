public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        
        int[] dp = new int[amount + 1];
        // transfer function
        // dp[i] = min{dp[i], dp[i - coins[j]] + 1}
        
        final int max = Integer.MAX_VALUE;
        
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }
        
        for (int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j] && dp[i - coins[j]] != max) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        return dp[amount] == max ? -1 : dp[amount];
    }
}