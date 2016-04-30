public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		Arrays.sort(nums);
		List<Integer> temp = new ArrayList<>();
		helper(nums, result, temp, 0);
		return result;
	}

	public void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, int pos) {
		result.add(new ArrayList(temp));

		for (int i = pos; i < nums.length; i++) {
			temp.add(nums[i]);
			helper(nums, result, temp, pos + 1);
			temp.remove(temp.size() - 1);
		}
	}
}