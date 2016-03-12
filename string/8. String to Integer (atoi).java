// corner case
// overflow: return INT_MAX or INT_MIN
// whitespaces: trim
// non integral char
// illegal input
// flag: 记录正负号

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
        	return 0;
        }

        str = str.trim();
        char flag = "+"; // sign
        int i = 0;
        if (str.charAt(0) == '-') {
        	flag = '-';
        	i++;
        } else if (str.charAt(0) == '+') {
        	i++;
        }

        double result = 0; // deal with overflow

        while (i < str.length()) {
        	if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
        		result = result * 10 + (str.charAt(i) - '0');

        	} else {
        		break;
        	}
        	i++;
        }

        if (flag == '-') {
        	result = -result;
        }

        if (result > Integer.INT_MAX) {
        	return Integer.INT_MAX;
        }

        if (result < Integer.INT_MIN) {
        	return Integer.INT_MIN;
        }

        return (int)result;

    }
}