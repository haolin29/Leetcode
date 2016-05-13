public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        int[] dp = new int[n];
        
        
        Arrays.fill(dp,1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}