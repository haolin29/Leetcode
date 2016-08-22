public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        
        x = Math.abs(x);
        int num = x;
        int re = 0;
        
        while(x != 0) {
            if(re > (Integer.MAX_VALUE - x % 10) / 10) {
                return false;
            }
            
            re = re * 10 + x % 10;
            x /= 10;
        }
        
        return re == num;
    }
}