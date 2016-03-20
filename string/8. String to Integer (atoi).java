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
        char flag = '+';
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

        if (result > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }

        return (int)result;

    }
}