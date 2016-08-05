public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null && num2 == null ) {
            return null;
        }
        
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int n = num1.length();
        int m = num2.length();
        int[] d = new int[n + m];
        
        for(int i = 0; i < n; i++) {
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < m; j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = 0; i < d.length; i++) {
            int digit = (d[i] + carry ) % 10;
            carry = (d[i] + carry ) / 10;
            
            sb.insert(0, digit);
        }
        
        // trim starting zero
        while(sb.length() != 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}