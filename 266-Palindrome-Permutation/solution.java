public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        int count = 0;
        for(Integer num : map.values()) {
            if(num % 2 == 1) {
                count++;
            }
        }
        
        return count <= 1;
    }
}