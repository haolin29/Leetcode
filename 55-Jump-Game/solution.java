public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int jump = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (i <= jump && jump < nums[i] + i) {
                jump = nums[i] + i;
            }
        }
        
        return jump >= nums.length - 1;
    }
}