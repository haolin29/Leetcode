public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        int layerNum = matrix.length / 2;
        int n = matrix.length;
        
        for (int layer = 0; layer < layerNum; layer++) {
            for(int i = layer; i < n - layer - 1; i++) {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n - i - 1][layer];
                matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
                matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
                matrix[i][n - 1 - layer] = temp;
                

            }
        }
        
    }
}