public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp[j] = max{dp[i], i < j && num[i] < num[j] } + 1  
        
        int[] dp = new int[nums.length];
        
        // init
        Arrays.fill(dp, 1);
        
        int max = 0;
        
        for(int j = 0; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if(nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }
            }
            max = Math.max(max, dp[j]);
        }
        
        return max;
    }
}