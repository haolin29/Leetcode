public class Solution {
    public boolean isMatch(String s, String p) {
        // edge case
        if (s.length() == 0) {
            return isEmpty(p);
        }
        
        if (p.length() == 0) {
            return false;
        }
        
        char s1 = s.charAt(0);
        char p1 = p.charAt(0), p2 = '0';
        
        if (p.length() > 1) {
            p2 = p.charAt(1);
        }
        
        if(p2 == '*') {
            if (compare(s1, p1)) {
                
                // 1. consume the character, and use the same pattern agian
                // 2. keep the character, skip the '*' cause '*' can be Match zero element
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if(compare(s1,p1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
        
    }
    private boolean isEmpty(String s) {
        if (s.length() % 2 != 0 ) {
            return false;
        }
        
        for (int i = 1; i < s.length(); i+=2) {
            if (s.charAt(i) != '*') {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean compare(char c1, char c2) {
        return c2 == '.' || c1 == c2;
    }
}