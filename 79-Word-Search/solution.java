public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }
        
        if(word == null || word.length() == 0) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] used = new boolean[n][m];
        
        // iterate starting point
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word, 0,used)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] used) {
        if(index == word.length()) {
            return true;
        }
        
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        used[i][j] = true;
        boolean res = dfs(board, i - 1, j, word, index + 1, used) ||
            dfs(board, i, j - 1, word, index + 1,used) ||
            dfs(board, i + 1, j, word, index + 1,used) ||
            dfs(board, i, j + 1, word, index + 1,used);
        used[i][j] = false;
        
        return res;
    }
}