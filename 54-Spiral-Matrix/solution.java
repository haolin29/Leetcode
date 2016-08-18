public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0) {
            return result;
        }
        
        int circle = 0;
        int row = matrix.length;
        int col = matrix[0].length; 
        while(circle * 2 < row && circle * 2 < col) {
            // top
            for(int i = circle; i < col - circle; i++) {
                result.add(matrix[circle][i]);
            }
            
            // right
            for(int i = circle + 1; i < row - circle; i++) {
                result.add(matrix[i][col - circle - 1]);
            }
            
            if(row - 2 * circle == 1 || col - 2 * circle == 1)  // if only one row /col remains
                break;
            
            // bottom
            for(int i = col - circle - 2; i >= circle; i--) {
                result.add(matrix[row - circle - 1][i]);
            }
            
            // left
            for(int i = row - circle - 2; i >= circle + 1; i--) {
                result.add(matrix[i][circle]);
            }
            
            circle++;
        }
        
        return result;
    }
}