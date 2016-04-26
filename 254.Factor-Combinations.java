public class Solution {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(n, result, list, 2);
		return result;
	}

	public void helper(int n, List<List<Integer>> result, List<Integer> list, int factor) {
		if (n <= 1) {
			if (list.size() > 1) {
				result.add(new ArrayList(list));
			}
			return;
		}

		for (int i = factor; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				helper(n / i, result, list, i);
				list.remove(list.size() - 1);
			}
		}
	}
}