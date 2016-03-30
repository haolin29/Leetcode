public class Solution {
    public int maxSubArray(int[] nums) {
        // Dynamic Programming
        // change condition is we should ignore the previous i - 1 elements if the ith element greater than sum of i elements.
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
            max = Math.max(max, sum[i]);
        }
        
        return max;
        
    }
}