public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,result,path, used,0);
        
        return result;
    }
    
    public void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, boolean[] used,int pos) {
        result.add(new ArrayList(path));
        
        for(int i = pos; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1] && used[i - 1] == false ) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, result, path, used,i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}