public class Solution {
    public int rob(int nums[]) {
        if (nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end) {
        int prev2 = nums[start];
        int prev1 = nums[start + 1];

        int cur = prev1;

        for (int i = start + 2; i < end; i++) {
            cur = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }   
}