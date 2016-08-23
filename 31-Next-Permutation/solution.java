public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if(i >= 0) {
            int j = i + 1;
            while(j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            j--;
            
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
    }
    
    public void reverse(int[] nums, int i ) {
        for(int j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}