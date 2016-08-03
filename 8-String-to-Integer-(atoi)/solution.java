public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        
        String s = str.trim();
        
        boolean neg = false;
        
        int index = 0;
        if (s.charAt(0) == '-') {
            neg = true;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        
        double result = 0;
        
        while(index < s.length()) {
            int digit = s.charAt(index) - '0';
            
            if(digit >= 0 && digit <= 9) {
                result = result * 10 + digit;
            } else {
                break;
            }
            
            index++;
        }
        
        result = neg ? -result : result;
        
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)result;
        
    }
}