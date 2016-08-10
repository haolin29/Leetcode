public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n < 1) {
            return result;
        }
        
        List<Integer> path = new ArrayList<>();
        dfs(n,k,result,path, 1);
        return result;
    }
    
    public void dfs(int n, int k,List<List<Integer>> result,List<Integer> path, int pos) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i <= n; i++) {
            path.add(i);
            dfs(n,k,result, path,i + 1);
            path.remove(path.size() - 1);
        }
    }
}