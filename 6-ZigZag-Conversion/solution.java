public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        if(numRows == 1) {
            return s;
        }
        
        int step = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && j + step - 2* i < s.length()) {
                    sb.append(s.charAt(j + step - 2 * i));
                }
            }
        }
        
        return sb.toString();
    }
}