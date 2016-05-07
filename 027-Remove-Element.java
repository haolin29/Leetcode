public class Solution {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0, j = 0;
		for (; j < nums.length; j++) {
			if(nums[i] == val) {
				if (nums[j] != val) {
					swap(nums, i,j);
					i++;
				}
			} else {
			    i++;
			}
		}

		return i;
	}

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    // more elegent solution 
    // 
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j  = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}
	
}

