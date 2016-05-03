public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
		    return result;
		}
		
		int n = nums.length;
		
		
		int candidate1 = 0,
			candidate2 = 0,
			counter1 = 0,
			counter2 = 0;

		for (int i = 0; i < nums.length; i++) {
			if (candidate1 == nums[i]) {
				counter1++;
			} else if (candidate2 == nums[i]) {
				counter2++;
			} else if (counter1 == 0) {
				candidate1 = nums[i];
				counter1 = 1;
			} else if (counter2 == 0) {
				candidate2 = nums[i];
				counter2 = 1;
			} else {
				counter1--;
				counter2--;
			}
		}

		counter1 = 0;
		counter2 = 0;
		for (int x:nums) {
			if (x == candidate1) {
				counter1++;
			} else if (x == candidate2) {
				counter2++;
			}
		}

		if (counter1 > n / 3) {
			result.add(candidate1);
		}
		if (counter2 > n / 3) {
			result.add(candidate2);
		}

		return result;
	}
}