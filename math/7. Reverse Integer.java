// corner case:
// what if the last digit is 0
// what if the reversed integer is overflows, return 0
// 

public class Solution {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
        	int tail = x % 10;
        	int newResult = result * 10 + tail;
        	if ((newResult - tail) / 10 != result) {
        		return 0;
        	}
        	result = newResult;
        	x /= 10;

        }

        return result;
    }
}