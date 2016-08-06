public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            while(i < j && !isAlphanumeric(s.charAt(i))) {
                i++;
            }
            
            while(i < j && !isAlphanumeric(s.charAt(j))) {
                j--;
            }
            
            if (i == j) break;
            
            if(!isSame(s.charAt(i), s.charAt(j))) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    public boolean isSame(char c1, char c2) {
        if(c1 >= 'A' && c1 <= 'Z') {
            c1 = (char)('a' + (c1 - 'A'));
        }
        
        if(c2 >= 'A' && c2 <= 'Z') {
            c2 = (char)('a' + (c2 - 'A'));
        }
        
        return c1 == c2;
    }
    
    public boolean isAlphanumeric(char c) {
        if(((c - 'a') >= 0 &&  (c - 'a') <= 26) || ((c - 'A') >= 0 &&  (c - 'A') <= 26) || 
            ((c - '0') >= 0 &&  (c - '0') <= 9) ) {
                return true;
            } 
        return false;
    }
}