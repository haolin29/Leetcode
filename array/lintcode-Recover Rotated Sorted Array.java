// Given a rotated sorted array, recover it to sorted array in-place.
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]


// 三步翻转法

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	if (nums == null || nums.size() == 0) {
    		return;
    	}

    	int len = nums.size();
    	for (int i = 1; i < len; i++) {
    		if (nums.get(i) < nums.get(i - 1)) {
    			reverse(nums, 0, i - 1);
    			reverse(nums, i, len - 1);
    			reverse(nums, 0, len - 1);
    		}
    	}
	}

	private void reverse(ArrayList<Integer> nums, int start, int end ) {
		for (; start < end; start++, end--) {
			int temp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, temp);
		}
	}

}
