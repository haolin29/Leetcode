public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,result, path, 0);
        return result;
        
    }
    
    public void dfs(int[] candidates, int target, List<List<Integer>> result, List<Integer> path, int pos) {
        if(target < 0) {
            return;
        }
        
        
        if(target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = pos; i < candidates.length; i++) {
            if(i != pos && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target - candidates[i], result, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}