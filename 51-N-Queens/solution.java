// ArrayList的 i 标示横坐标， get(i) 表示纵坐标
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        
        search(n,new ArrayList<Integer>(), result);
        return result;
    }
    
    public void search(int n, ArrayList<Integer> cols, List<List<String>> result) {
        if (cols.size() == n) {
            draw(cols,result);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!isValid(i, cols)) {
                continue;
            }
            cols.add(i);
            search(n, cols, result);
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(int col, ArrayList<Integer> cols) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (row - col == i - cols.get(i)) {
                return false;
            }
            if (row + col == i + cols.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void draw(ArrayList<Integer> cols, List<List<String>> result) {
        int n = cols.size();
        ArrayList<String> line = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s ="";
            for (int j = 0; j < n; j++) {
                if (j == cols.get(i)) {
                    s += "Q";
                } else {
                    s += ".";
                }
            }
            line.add(s);
        }
        result.add(line);
    }
}