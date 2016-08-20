public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        List<Integer> path = new ArrayList();
        
        dfs(nums, result, path);
        
        return result;
    }
    
    public void dfs(int[] nums, List<List<Integer>> result,  List<Integer> path) {
        if(path.size() == nums.length ) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(path.contains(nums[i])) {
                continue;
            }
            
            path.add(nums[i]);
            dfs(nums, result, path);
            path.remove(path.size() - 1);
        }
    }
}