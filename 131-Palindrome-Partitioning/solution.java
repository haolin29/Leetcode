public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        List<String> path = new ArrayList<>();
        dfs(s, result, path);
        return result;
    }
    
    public void dfs(String s, List<List<String>> result, List<String> path) {
        if(s.length() == 0) {
            result.add(new ArrayList(path));
            return;
        }
        
        for(int i = 1; i <= s.length(); i++) {
            if(!isPalindrome(s.substring(0, i))) {
                continue;
            }
            path.add(s.substring(0, i));
            dfs(s.substring(i), result, path);
            path.remove(path.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
        
        
    }
}