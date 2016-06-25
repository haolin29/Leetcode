public class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int color = 0;
        while (true) {
            while (start < end && nums[start] == color) {
                start++;
            }

            while (start < end && nums[end] != color) {
                end--;
            }

            if (start == end ) {
                if (color < 3) {
                    color++;
                    end = nums.length - 1;
                } else {
                    break;
                }
            }

            // swap color
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
    }
}