public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s == null || s.length() == 0) {
            return result;
        }
        
        dfs(s, "", result, 0, 1);
        
        return result;
    }
    
    public void dfs(String s, String item, List<String> result, int index, int segment) {
        if(index >= s.length()) {
            return;
        }
        
        if(segment == 4 ) {
            String str = s.substring(index);
            if(isValid(str)) {
                result.add(item + "." + str);
            }
            return;
        }
        
        for(int i = 1; i < 4 && (index + i <= s.length()); i++ ) {
            String str = s.substring(index, index + i);
            
            if(isValid(str)) {
                if(segment == 1) {
                    dfs(s, str, result, index + i, segment + 1 );
                } else {
                    dfs(s, item + "." + str, result, index + i, segment + 1);
                }
            }
        }
    }
    
    public boolean isValid(String s) {
        if(s == null || s.length() > 3) {
            return false;
        }
        
        int num = Integer.parseInt(s);
        
        if(s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        
        if(num >= 0 && num <= 255) {
            return true;
        }
        
        return false;
    }
}