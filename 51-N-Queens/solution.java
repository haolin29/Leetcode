public class Solution {
    
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        if(n < 1) {
            return result;
        }
        
        List<Integer> cols = new ArrayList<>();
        dfs(n, result, cols);
        
        return result;
        
    }
    
    public void dfs(int n, List<List<String>> result, List<Integer> cols) {
        if(cols.size() == n) {
            result.add(drawBoard(cols));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!isValid(cols, i)) {
                continue;
            }
            
            cols.add(i);
            dfs(n, result, cols);
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
    
    public List<String> drawBoard(List<Integer> cols) {
        List<String> sol = new ArrayList<>();
        
        for(int i = 0; i < cols.size(); i++) {
            String str = "";
            for(int j = 0; j < cols.size(); j++) {
                if(cols.get(i) == j) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            
            sol.add(str);
        }
        
        return sol;
    } 
}