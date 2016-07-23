public class NumMatrix {

    private int[][] f; // the region sum from (0,0) to i,j
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        f = new int[m + 1][n + 1];
        
        // f[i][j] = f[i - 1][j] + rowSum
        // sumRegion(i1,j1,i2,j2) = f[i2 + 1, j2 + 1] - f[i1, j2 + 1] - f[i2 + 1, j1]
        for(int i = 1; i <= m; i++) {
            int rowSum = 0;
            for(int j = 1; j <= n; j++) {
                rowSum += matrix[i - 1][j - 1];
                f[i][j] = f[i - 1][j] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return f[row2 + 1][col2 + 1] - f[row1][col2 + 1] - f[row2 + 1][col1] + f[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);