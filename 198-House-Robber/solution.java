public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        
        int[] rob = new int[n]; // define: before i I can rob max money
        rob[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            if(i == 1) {
                rob[1] = Math.max(nums[0], nums[1]);
            } else {
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i]);
            }
        }
        
        return rob[n-1];
    }
}