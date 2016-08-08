public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        int count = 0;
        int left = 0;
        int miniLen = s.length() + 1;
        int miniStart = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                
                if(map.get(c) >= 0) {
                    count++;
                }
                
                while(count == t.length()) {
                    if(i - left + 1 < miniLen) {
                        miniLen = i - left + 1;
                        miniStart = left;
                    }
                    
                    char ct = s.charAt(left);
                    if(map.containsKey(ct)) {
                        map.put(ct, map.get(ct) + 1);
                        
                        if(map.get(ct) > 0) {
                            count--;
                        }
                    }
                    
                    left++;
                }
                
                
            }
        }
        
        if (miniLen > s.length()) {
            return "";
        }
        
        return s.substring(miniStart, miniStart + miniLen);
        
    }
}