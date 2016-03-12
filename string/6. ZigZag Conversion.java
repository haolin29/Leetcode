//  可以发现规律，画红色的长度永远是 2n-2 
//  （想法是你试想把所有这些行压缩成两列，两边手挤一下，第二列永远的第一行和最后一行少字）。
//  利用这个规律，可以按行填字，第一行和最后一行，就是按照2n-2的顺序一点点加的。
//  其他行除了上面那个填字规则，就是还要处理斜着那条线的字，可以发现那条线的字的位置永远是当前列j+(2n-2)-2i(i是行的index）。 

// 坐标转换，多写几个例子找规律


public class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows < 1) {
            return "";
        }

        if (numRows == 1) return s;
        
        StringBuilder sb = new StringBuilder();

        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
        	for (int j = i; j < s.length(); j+= step) {
        		sb.append(s.charAt(j));

        		if (i != 0 && i != numRows - 1) {
        			int temp = j + step - 2*i;
        			if (temp < s.length()) {
        				sb.append(s.charAt(temp));
        			}
        		}
        	}
        }

        return sb.toString();
    }
}