public class Solution {
    public int maxSubArray(int[] nums) {
        // prefix sum
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        
        return max;
        
    }
}