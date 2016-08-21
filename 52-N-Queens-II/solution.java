public class Solution {
    
    int count;
    public int totalNQueens(int n) {
        if(n < 1) {
            return 0;
        }
        count = 0;
        List<Integer> cols = new ArrayList<>();
        dfs(n, cols);
        
        return count;
        
    }
    
    public void dfs(int n, List<Integer> cols) {
        if(cols.size() == n) {
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!isValid(cols, i)) {
                continue;
            }
            
            cols.add(i);
            dfs(n, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        
        for(int i = 0; i < cols.size(); i++) {
            if(col == cols.get(i) || Math.abs(i - row) == Math.abs(cols.get(i) - col) ) {
                return false;
            }
        }
        
        return true;
    }
    
}