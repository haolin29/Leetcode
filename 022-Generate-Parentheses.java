public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		helper(result, "", n, n);
		return result;
	}

	public void helper(List<String> result, String str, int left, int right) {
		if (left > right) {
			return;
		}

		if (left == 0 && right == 0) {
			result.add(str);
			return;
		}

		if (left > 0) {
			helper(result, str + "(", left - 1, right);
		}

		if (right > 0) {
			helper(result, str + ")", left, right - 1);
		}
	}
}