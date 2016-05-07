public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        helper(result, path, k, n, 1);
        return result;
    }


    public void helper(List<List<Integer>> result, List<Integer> path, int k, int n, int pos) {
    	if (path.size() == k) {
    		if (n == 0) {
    			result.add(new ArrayList(path));
    		}
    		return;
    	}

    	for (int i = pos; i <= 9; i++) {
    		if (i > n) break;
    		path.add(i);
    		helper(result, path, k, n - i, i + 1);
    		path.remove(path.size() - 1); 
    	}
    }
}