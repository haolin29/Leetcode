public class Solution {
    // key point: use a 1-d array to representation by the position as row and the value as col.
    public static int result;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        result = 0;
        searchDown(n, new ArrayList<>());
        return result;
    }
    
    public void searchDown(int n, ArrayList<Integer> cols) {
        // base case 
        if (cols.size() == n) {
            result++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!isValid(i, cols)) {
                continue;
            }
            cols.add(i);
            searchDown(n, cols);
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(int col, ArrayList<Integer> cols) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (row - col == i - cols.get(i) ) {
                return false;
            }
            if (row + col == i + cols.get(i) ) {
                return false;
            }
        }
        return true;
    }
}