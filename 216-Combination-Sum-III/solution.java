public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < k) {
            return result;
        }
        List<Integer> path = new ArrayList<>();
        dfs(k,n, result, path, 1);
        return result;
        
    }
    
    public void dfs(int k, int n, List<List<Integer>> result, List<Integer> path, int start) {
        if(n < 0) {
            return;
        }
        
        if(path.size() == k && n == 0) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = start; i <= 9 ; i++) {
            path.add(i);
            dfs(k, n - i, result, path, i + 1);
            path.remove(path.size() - 1);
        }
        
    }
}