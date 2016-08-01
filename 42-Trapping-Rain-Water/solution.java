public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            
            if(height[left] == min) {
                left++;
                
                while(left < right && height[left] <= min) {
                    result += min - height[left];
                    left++;
                }
            } else {
                right--;
                
                while(left < right && height[right] <= min) {
                    result += min - height[right];
                    right--;
                }
            }
        }
        
        return result;
    }
}