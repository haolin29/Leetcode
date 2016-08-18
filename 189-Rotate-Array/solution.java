public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        
        int n = nums.length;
        
        k = k % n;
        
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
    
    
    public void reverse(int[] nums, int start, int end) {
        for(; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}