public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if(i != s.length() - 1 &&  map.get(c) < map.get(s.charAt(i + 1)) ) {
                result -= map.get(c);
            } else {
                result += map.get(c);
            }
        }
        
        return result;
    }
}