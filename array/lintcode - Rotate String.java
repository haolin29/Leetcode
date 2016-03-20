// Given a string and an offset, rotate string by offset. (rotate from left to right)
// offset=0 => "abcdefg"
// offset=1 => "gabcdef"
// offset=2 => "fgabcde"
// offset=3 => "efgabcd"

// approach: 三步翻转法
// 
public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
    	 if (str == null || str.length == 0) {
    	 	return;
    	 }

    	 int len = str.length;

    	 // what if offset larger than the length
    	 offset = offset % len;

    	 reverse(str, 0, len - offset - 1);
    	 reverse(str, len - offset, len - 1);
    	 reverse(str, 0, len - 1);
	}

	public void reverse(char[] str, int start, int end) {
		for (; start < end; start++, end--) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
		}
	}
}