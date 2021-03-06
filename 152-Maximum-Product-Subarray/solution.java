public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        int[] max = new int[n];
        int[] min = new int[n];
        
        max[0] = nums[0];
        min[0] = nums[0];
        
        
        for(int i = 1; i < n; i++) {
            if(nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
        }
        
        int res = Integer.MIN_VALUE; 
        for(int i = 0; i < n; i++) {
            res = Math.max(res, max[i]);
        }
        
        return res;
    }
}