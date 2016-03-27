public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int count = 0;
        
        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '(' ) {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    count = 0;
                } else {
                    int matchLen = i - stack.pop() + 1;
                    
                    if (stack.isEmpty()) {
                        count += matchLen;
                        matchLen = count;
                    } else {
                        matchLen = i - stack.peek();
                    }
                    
                    maxLen = Math.max(maxLen, matchLen);
                }
            }
        }
        
        return maxLen;
    }
}