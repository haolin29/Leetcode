public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        int minLen = Integer.MAX_VALUE;
        
        for(int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        
        int len = 0;
        
        for(int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            int j;
            for(j = 0; j < strs.length; j++) {
                if(j == strs.length - 1 && c == strs[j].charAt(i)) {
                    len++;
                } else {
                   if(c == strs[j].charAt(i)) {
                    continue;
                    } else {
                        break;
                    } 
                }
            }
            
            if(j != strs.length) {
                break;
            }
        }
        
        return strs[0].substring(0, len);
    }
}