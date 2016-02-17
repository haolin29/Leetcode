// recursion version
// backtracking

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;

        Arrays.sort(nums);
        
        List<Integer> temp = new ArrayList<Integer>();
        helper(result, nums, 0, temp);

        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, int index, List<Integer> tmp) {
    	// why needs to new ArrayList(tmp) in each recursion. Because if you 
    	// don't new a arraylist, all the tmp pointed to same one, and the object 
    	// will be remove element after recursion, so eventually it will became 
    	// empty. You need to store the current state of the tmp, that is why we 
    	// need to new ArrayList(tmp), cause it is a global variable.
    	result.add(new ArrayList(tmp)); 

    	for (int i = index; i < nums.length; i++) {
    		tmp.add(nums[i]);
    		helper(result, nums, i + 1, tmp);
    		tmp.remove(tmp.size() - 1);
    	}

    }
}