public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n < 1) return result;
        
        dfs(result, new String(), n, n);
        
        return result;
    }
    
    public void dfs(List<String> result, String sb, int left, int right) {
        if(left > right) {
            return;
        }
        
        if(left == 0 && right == 0) {
            result.add(sb);
            
        }
        
        
        if(left > 0) {
            dfs(result, sb + "(", left - 1, right);
        } 
        
        if(right > 0) {
            dfs(result, sb + ")", left, right - 1);
        }
    }
}