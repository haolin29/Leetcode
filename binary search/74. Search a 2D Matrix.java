// look the matrix as a big sorted array
// 
// how to get the row and col matrix[mid/col][mid % col]

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        int col = matrix[0].length;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int mid_value = matrix[mid / col][mid % col];
            if (mid_value == target) {
                return true;
            } else if (mid_value < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / col][start % col] == target) {
            return true;
        } else if (matrix[end / col][end % col] == target){
            return true;
        } else {
            return false;
        }

        
        
    }
}