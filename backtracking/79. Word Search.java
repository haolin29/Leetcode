// Recursion It's a DFS.

public class Solution {
    public boolean exist(char[][] board, String word) {
    	if (board == null || board.length == 0 || word == null) {
    		return false;
    	}
        
        char[] wd = word.toCharArray();
        // check whether this cell have been visited
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (helper(board, wd, 0, i, j, check)) 
        		    return true;
        	}
        }

        return false;

    }

    public boolean helper(char[][] board, char[] wd, int i, int x, int y, boolean[][] check) {
    	if (i == wd.length) return true;
    	if (x < 0 || y < 0 || x >= board.length|| y >= board[0].length) return false;
    	if (check[x][y] == true || board[x][y] != wd[i]) return false;
    	check[x][y] = true;
    	boolean exist = helper(board, wd, i + 1, x + 1, y, check) || helper(board, wd, i + 1, x - 1, y, check) || helper(board, wd, i + 1, x, y + 1, check) || helper(board, wd, i + 1, x, y - 1, check);
    	check[x][y] = false;
    	return exist;
    }
}