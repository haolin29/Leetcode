public class Solution {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		if (n < 3) {
			return n;
		}

		int i = 1;
		int j = 2;

		// keep the i and the third duplicate element than swap with the next one
		for (;j < n;j++) {
			if (nums[i - 1] != nums[i] || nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
				
			}
		}

		return i + 1;
	}
}