public class Solution {
    public void rotate(int[] nums, int k) {
        // three way reverse
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
        
    }
    
    public void reverse(int[] nums, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}