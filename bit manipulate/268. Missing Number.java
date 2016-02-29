//The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.

public class Solution{
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}