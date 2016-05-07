public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int p1 = 0;
        int p2 = s.length() - 1;
        String n = s.toLowerCase();

        while (p1 < p2) {
        	while(p1 < p2 && !Character.isLetterOrDigit(n.charAt(p1))) p1++;
        	while(p1 < p2 && !Character.isLetterOrDigit(n.charAt(p2))) p2--;
        	if (n.charAt(p1) != n.charAt(p2)) return false;
        	p1++;
        	p2--;
        }
        return true;

    }
}