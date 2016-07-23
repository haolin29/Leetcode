public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }

        int n = nums.length;

        if (nums.length == 1) {
            return nums[0];
        }


        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        int cur = prev1;
        for (int i = 2; i < n; i++) {
            cur = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;   
    }
}