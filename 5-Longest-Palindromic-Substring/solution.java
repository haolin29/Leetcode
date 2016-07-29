public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        int max = 0;
        String result = "";
        
        for(int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = i / 2;
            
            if(i % 2 == 1) {
                right++;
            }
            
            String str = getPalindrome(s, left, right);
            
            if (max < str.length()) {
                max = str.length();
                result = str;
            }
        }
        
        return result;
    }
    
    public String getPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left+1,right);
    }
}