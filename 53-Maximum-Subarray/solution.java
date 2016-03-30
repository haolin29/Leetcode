public class Solution {
    public int maxSubArray(int[] nums) {
        // Dynamic Programming
        // change condition is we should ignore the previous i - 1 elements if the ith element greater than sum of i elements.
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        //int[] sum = new int[n];
        int sum = nums[0];
        //sum[0] = nums[0];
        int max = sum;
        for (int i = 1; i < n; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
        
    }
}