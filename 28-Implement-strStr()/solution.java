public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        
        if(haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        
        int m = haystack.length();
        int n = needle.length();
        
        int index = 0;
        for(int i = 0; i < m - n; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                for(int j = 1; j < n; j++) {
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        break;
                    }
                    if(j == n - 1) {
                        index = i;
                    }
                } 
            }
            
        }
        
        return index;
    }
}