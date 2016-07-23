public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }

        int n = nums.length;

        if (nums.length == 1) {
            return nums[0];
        }


        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);

        int cur = prev2;
        for (int i = 2; i < n; i++) {
            cur = Math.max(prev1 + nums[i], prev2);
            prev1 = prev2;
            prev2 = cur;
        }

        return cur;   
    }
}