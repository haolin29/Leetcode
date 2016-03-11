/**
 * keep a hashmap which stores the characters in string as keys and their positions as values, 
 * and keep two pointers which define the max substring. 
 * move the right pointer to scan through the string , and meanwhile update the hashmap. 
 * If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;

        for (int left = 0, right = 0; right < s.length(); right++ ) {
        	if (map.containsKey(s.charAt(right))) {
        		left = Math.max(left, map.get(s.charAt(right))+ 1);

        	}

        	map.put(s.charAt(right), right);
        	max = Math.max(max, right - left + 1);
        }

        return max;
    }
}