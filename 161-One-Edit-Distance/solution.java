public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null && t == null) {
            return false;
        }
        
        int m = s.length();
        int n = t.length();
        
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(s.charAt(i) != t.charAt(j)) {
                if(m == n) {
                    // modified
                    return s.substring(i + 1).equals(t.substring(j + 1));
                } else {
                    // add or delete
                    return s.substring(i).equals(t.substring(j + 1)) || s.substring(i + 1).equals(t.substring(j));    
                }
            } 
            
            i++;
            j++;
        }
        
        return Math.abs(m - n) == 1;
    }
}