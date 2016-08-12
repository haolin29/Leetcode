public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        
        int rmL = 0;
        int rmR = 0;
        
        // count how many parenthese need to be removed
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') rmL++;
            
            if(s.charAt(i) == ')') {
                if(rmL != 0) rmL--;
                else rmR++;
            }
            
        }
        
        dfs(s, set, 0, rmL, rmR, 0, new StringBuilder());
        
        return new ArrayList<String>(set);
    }
    
    public void dfs(String s, Set<String> set, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            set.add(sb.toString());
            return;
        }
        
        // exit condition
        if(i >= s.length() || rmL < 0 || rmR < 0 || open < 0) {
            return;
        }
        
        char c = s.charAt(i++);
        // mark
        int len = sb.length();
        
        if(c == '(') {
            // remove it
            dfs(s,set,i,rmL-1,rmR, open, sb);
            // add it
            dfs(s,set,i,rmL,rmR,open + 1, sb.append(c));
        } else if(c == ')') {
            // remove 
            dfs(s,set,i,rmL,rmR - 1,open,sb);
            // add
            dfs(s,set,i,rmL,rmR,open - 1,sb.append(c));
        } else {
            // add it 
            dfs(s,set,i,rmL,rmR,open,sb.append(c));
        }
        //backtracking
        sb.setLength(len);
        
    }
}