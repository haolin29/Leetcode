public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        if(s.length() != t.length()) return false;
        
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        
        for(char c: s1) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        for(char c:t1) {
            map.put(c, map.get(c) - 1);
        }
        
        for(Integer i : map.values()) {
            if(i != 0) {
                return false;
            }
        }
        
        return true;
    }
}