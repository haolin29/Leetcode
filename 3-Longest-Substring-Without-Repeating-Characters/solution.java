public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 窗口法
        HashSet<Character> set = new HashSet<>();
        
        int maxLen = 0;
        int left = 0;
        int right = 0;
        
        while(right < s.length()) {
            
            if(set.contains(s.charAt(right))) {
                maxLen = Math.max(maxLen, right - left);
                
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                
            } else {
                set.add(s.charAt(right));
            }
            
            right++;
        }
        
        maxLen = Math.max(maxLen, right - left);
        return maxLen;
    }
}