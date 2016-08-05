public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int p1 = 0;
        int p2 = 0;
        int n = nums.length;
        while(p1 < n && p2 < n) {
            while(p1 < n && nums[p1] != 0) {
                p1++;
            }
            
            while(p2 < n && nums[p2] == 0) {
                p2++;
            }
            
            if(p1 == n || p2 == n ) break;
            
            if (p1 < p2) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }
        
        
    }
}