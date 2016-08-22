public class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }
        
        boolean neg = false;
        
        if(x < 0) {
            neg = true;
            x = -x;
        }
        
        long result = 0;
        
        while(x != 0) {
            int digit = x % 10;
            x /= 10;
            result *= 10;
            result += digit;
        }
        
        if(result > Integer.MAX_VALUE) {
            return 0;
        }
        
        return neg ? -(int)result : (int)result;
    }
}