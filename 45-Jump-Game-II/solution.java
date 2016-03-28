// 11:30 - 12:47
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int reach = 0;
        int lastReach = 0;
        int minStep = 0;
        
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                minStep++;
                lastReach = reach;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        
        return minStep;
        
    }
}