public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int leftH = height[left];
        int rightH = height[right];
        int sumOfWater = 0;
        while (left < right) {
            while (left < right && leftH >= height[left] && leftH <= rightH) {
                sumOfWater += leftH - height[left];
                left++;
            }
            // need to update height
            if (left < right) {
                leftH = height[left];
            }
            while (left < right && rightH >= height[right] && leftH >= rightH) {
                sumOfWater += rightH - height[right];
                right--;
            }
            if (left < right) {
                rightH = height[right];
            }
        }

        return sumOfWater;
        
        
    }
}