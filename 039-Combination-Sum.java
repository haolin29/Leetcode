public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		combination(candidates,target,result,temp,0,0);

		return result;

	}

	public void combination(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int sum, int pos) {

		// sum is the sum of the temp elements
		for (int i = pos; i < candidates.length; i++) {
			if (sum == target) {
				result.add(new ArrayList(temp));
				sum = 0;
				return;
			}


			if (sum < target) {
				temp.add(candidates[i]);
				combination(candidates,target, result,temp, sum + candidates[i], i);
				sum -= temp.get(temp.size() - 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
}