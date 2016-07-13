public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? -1 : heights[i];
            while(!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, width * height);
            }
            stack.push(i);
            
        }
        
        return max;
        
    }
}