public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int i0 = 0;
        int i1 = 0;
        
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = 2;
                nums[i1++] = 1;
                nums[i0++] = 0;
            } else if(nums[i] == 1) {
                nums[i] = 2;
                nums[i1++] = 1;
            }
        }
        
    }
}