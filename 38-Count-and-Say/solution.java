public class Solution {
    public String countAndSay(int n) {
        if(n < 1) {
            return "";
        }
        
        
        String cur = "1";
        for(int i = 2; i <= n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < cur.length(); j++) {
                if(cur.charAt(j) == cur.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(cur.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(cur.charAt(cur.length() - 1));
            cur = sb.toString();
        }
        
        return cur;
    }
}