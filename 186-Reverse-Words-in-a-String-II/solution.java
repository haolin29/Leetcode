public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }
        
        int start = 0;
        int end = s.length - 1;
        for(int i = 0; i < s.length; i++) {
            if(i == s.length - 1) {
                reverse(s, start, i);
            } else if(s[i] == ' ') {
                end = i - 1;
                reverse(s,start,end);
                start = i + 1;
            }
        }
        
        reverse(s,0,s.length - 1);
        
        
    }
    
    public void reverse(char[] A, int start, int end) {
        for(;start < end; start++, end--) {
            char temp = A[end];
            A[end] = A[start];
            A[start] = temp;
        }
    }
}