public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;


        int rows = matrix.length;
        int cols = matrix[0].length;

        // to enbale o(1), we should keep the state in the matrix
        boolean emptyRow0 = false;
        boolean emptyCol0 = false;


        for (int i = 0; i < rows; i++) {
        	if (matrix[i][0] == 0) {
        		emptyRow0 = true;
        	}
        }

        for (int i = 0; i < cols; i++) {
        	if (matrix[0][i] == 0) {
        		emptyCol0 = true;
        	}
        }

        for (int i = 1; i < rows; i++) {
        	for (int j = 1; j < cols; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }

        for (int i = 1; i < rows; i++) {
        	for (int j = 1; j < cols; j++) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }

        if (emptyRow0) {
        	for (int i = 0; i < rows; i++) {
        		matrix[i][0] = 0;
        	}
        }

        if (emptyCol0) {
        	for (int i = 0; i < cols; i++) {
        		matrix[0][i] = 0;
        	}
        }


    
    }
}