public class Solution {
	public int maxArea(int[] heights) {
		int result = 0;
		int left = 0;
		int right = heights.length - 1;
		while (left < right) {
			result = Math.max(result, (right - left) * Math.min(heights[left],heights[right]));
			if (heights[left] >= heights[right]) {
				right--;
			} else {
				left++;
			}
		}

		return result;
	}
}