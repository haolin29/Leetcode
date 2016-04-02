public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        helper(result, list, s, 0);
        return result;
    }
    
    public void helper(List<String> result, List<String> list, String s, int start) {
        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            } 
            StringBuilder sb = new StringBuilder();
            for (String t: list) {
                sb.append(t);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String tmp = s.substring(start,i+1);
            if(isValid(tmp)){
                list.add(tmp);
                helper(result,list,s,i+1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        } else {
            int digits = Integer.valueOf(s);
            return digits >= 0 && digits <= 255;
        }
        
        
    }
}