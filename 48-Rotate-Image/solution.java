public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int layerNum = matrix.length / 2;
        int n = matrix.length;
        
        for (int layer = 0; layer < layerNum; layer++) {
            for(int i = layer; i < n - layer - 1; i++) {
                int temp = matrix[layer][n - i];
                matrix[layer][n - i] = matrix[n - layer - 1][i];
                matrix[n - 1 - layer][i] = matrix[n - 1 - layer][n - i];
                matrix[n - 1 - layer][n - i] = matrix[i][n - 1 - layer];
                matrix[i][n - 1 - layer] = temp;
            }
        }
        
    }
}