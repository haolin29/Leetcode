// very similiar with subsets
// use the subsets template
// backtracking
// 
// reminder:pos


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        helper(n,k,result,temp,1);
        return result;
    }

    public void helper(int n, int k, List<List<Integer>> result, List<Integer> temp, int pos) {
    	if (temp.size() == k) {
    		result.add(new ArrayList(temp));
    		return;
    	}

    	for (int i = pos; i <= n; i++) {

    		temp.add(i);
			// taking care about the pos index, easy to fault
    		helper(n,k,result,temp,i + 1);
    		temp.remove(temp.size() - 1);
    	}
    }
}