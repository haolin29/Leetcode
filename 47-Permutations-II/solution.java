public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        List<Integer> path = new ArrayList();
        
        boolean[] visited = new boolean[nums.length];
        dfs(nums, result, path, visited);
        
        return result;
    }
    
    public void dfs(int[] nums, List<List<Integer>> result,  List<Integer> path, boolean[] visited) {
        if(path.size() == nums.length ) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i != 0 && !visited[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            }
            
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, result, path,visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}