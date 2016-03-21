// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

public class Solution {
    public String reverseWords(String s) {
    	if (s == null || s.length() == 0) {
    		return "";
    	}

    	String[] str = s.split(" ");
    	StringBuilder sb = new StringBuilder();
    	for (int i = str.length - 1; i >= 0; i--) {
    		if(!str[i].equals("")) {
    			sb.append(str[i]).append(" ");
    		}
    	}
    	return sb.toString().trim();
    }
}