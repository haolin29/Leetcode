public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            n--; // change to base 0
            char c = (char)(n % 26 + 'A');
            n /= 26;
            sb.append(c);
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}