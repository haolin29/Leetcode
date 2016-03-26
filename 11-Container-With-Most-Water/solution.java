public class Solution {
    public int maxArea(int[] height) {
        int left = 0, result = 0;
        int right = height.length - 1;
        while (left < right) {  // because it's a contianer so left can equal to right
            result = Math.max(result, (right - left) * Math.min(height[right],height[left]) );
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        
        return result;
    }
}