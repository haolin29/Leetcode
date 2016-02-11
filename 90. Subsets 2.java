// Given a collection of integers that might contain duplicates, nums, return all 
// possible subsets.
// 


// idea
// backtracking approach
// how to handle duplicate
// have to get duplicate element by order
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();

        helper(result, nums, temp, 0);

        return result;
    }

    public void helper(List<List<Integer>> result,int[] nums,List<Integer> temp, int index) {
    	result.add(new ArrayList(temp));

    	for (int i = index; i < nums.length; i++) {
    		//  i != index means that we fetch int from next level in the dfs tree 
    		if (i != index && nums[i] == nums[i - 1]) continue;

    		temp.add(nums[i]);
    		helper(result,nums,temp,i + 1);
    		temp.remove(temp.size() - 1);
    	}
    }
}
