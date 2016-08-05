public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) {
            return null;
        }
        
        if(a == null || b == null) {
            return a == null ? b : a;
        }
        
        
        if(b.length() > a.length()) {
            String temp = b;
            b = a;
            a = temp;
            
        }
        
        int n = a.length();
        int m = b.length();
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        for(int j = m - 1; j >= 0; i--,j--) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
                carry = sum / 2;
                sum %= 2;
                sb.insert(0, (char)(sum + '0'));
        }
        
        for(; i>= 0; i--) {
            int sum = (a.charAt(i) - '0')+ carry;
            
                carry = sum / 2;
                sum %= 2;
                sb.insert(0,(char)(sum + '0'));
        }
        
        if(carry != 0) {
            sb.insert(0, (char)(carry + '0'));
        }
        
        return sb.toString();
        
    }
}