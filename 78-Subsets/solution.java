public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        
        dfs(nums, result, path, 0);
        
        return result;
        
    }
    
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int pos) {
        result.add(new ArrayList(path));
        
        for(int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}