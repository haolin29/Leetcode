public class Solution {
	public int maxSubArray(int[] nums) {

		// key point: contiguous subarray
		if (nums == null || nums.length == 0) return 0;

		int sum = nums[0];
		int max = sum;

		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], nums[i] + sum);
			max = Math.max(max, sum);
		}

		return max;
	}
}