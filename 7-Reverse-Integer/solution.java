public class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        
        int num = x;
        
        x = Math.abs(x);
        
        int result = 0;
        while(x != 0) {
            if(result > (Integer.MAX_VALUE - x % 10) / 10) {
                return 0;
            }
            
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        return num > 0 ? result : -result;
        
    }
}