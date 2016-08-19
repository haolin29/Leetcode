public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length; i++) {
            int s = i + 1;
            int e = nums.length - 1;
            
            while(s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                if(sum < target) {
                    s++;
                } else {
                    e--;
                }
            
                
            }
        }
        
        return closest;
    }
}