public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(6,9);
        map.put(1,1);
        map.put(8,8);
        map.put(9,6);
        map.put(0,0);
        
        
        
        for(int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            int n = num.charAt(i) - '0';
            if(!map.containsKey(n) || map.get(n) != num.charAt(j) - '0') {
                return false;
            }
        }
        
        return true;
    }
}