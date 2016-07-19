public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    start = 0;
                } else {
                    int matchLens = i - stack.pop() + 1;
                    if(stack.isEmpty()) {
                        matchLens += start;
                        start = matchLens;
                    } else {
                        matchLens = i - stack.peek();
                    }
                    
                    max = Math.max(max, matchLens);
                }
                
            }
        }
        return max;
    }
}