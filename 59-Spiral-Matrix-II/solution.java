public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int count = 0;
        int num = 0;
        int rows = n;
        int cols = n;
        while (count * 2 < rows && count * 2 < cols) {
            for (int i = count; i < cols - count; i++) {
                num++;
                res[count][i] = num;
            }
            
            for (int i = count + 1; i < rows - count; i++) {
                num++;
                res[i][cols - count - 1] = num;
            }
            
            if (rows - 2 * count == 1 || cols - 2 * count == 1) {
                break;
            }
            
            for (int i = cols - count - 2; i >= count; i--) {
                num++;
                res[rows - count - 1][i] = num;
            }
            
            for (int i = rows - count - 2; i >= count + 1; i--) {
                num++;
                res[i][count] = num;
            }
            count++;
            
        }
        return res;
    }
}