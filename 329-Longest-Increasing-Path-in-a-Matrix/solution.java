public class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mem = new int[m][n];
        
        int longest = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(matrix, i, j, mem) + 1);
            }
        }
        
        return longest;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if(mem[i][j] != 0) {
            return mem[i][j];
        }
        
        
        for(int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            
            if(x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, x, y, mem) + 1);
            }
        }
        
        return mem[i][j];
    }
}