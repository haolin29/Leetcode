public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, false);
        }
        
        int max = 0;
        for(int num : nums) {
            if(map.get(num)) {
                continue;
            }
            int i = num;
            int count = 0;
            while(map.containsKey(i)) {
                map.put(i, true);
                i++;
                count++;
            }
            i = num - 1;
            while(map.containsKey(i)) {
                map.put(i, true);
                i--;
                count++;
            }
            
            max = Math.max(count, max);
        }
        
        return max;
    }
}