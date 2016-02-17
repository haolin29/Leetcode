// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // have to be sort
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums,result,temp,visited);
        
        return result;
        
    }
    public void helper(int[] nums, List<List<Integer>> result, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
        	if (visited[i] || (  i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)) continue;

        	visited[i] = true;
            temp.add(nums[i]);
            helper(nums,result,temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}