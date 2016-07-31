public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else if(map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
        
    }
}