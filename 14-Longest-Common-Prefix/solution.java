public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        int index = 0;
        
        boolean same = true;
        
        StringBuilder sb = new StringBuilder();
        
        while(same) {
            
            for(int i = 0; i < strs.length; i++) {
                if(strs[i].length() <= index || strs[i].charAt(index) != strs[0].charAt(index)) {
                    same = false;
                    break;
                }
            }
            
            if(same) {
                sb.append(strs[0].charAt(index));
                index++;
            }
            
            
        }
        
        return sb.toString();
    }
}