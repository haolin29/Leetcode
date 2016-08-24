public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        
        int prev = lower - 1;
        int cur = 0;
        
        for(int i = 0; i <= nums.length; i++) {
            cur = i == nums.length ? upper + 1 : nums[i];
            
            if(cur - prev > 1 ){
                result.add(getRange(prev + 1, cur - 1));
            }
            prev = cur;
        }
        
        return result;
    }
    
    public String getRange(int left, int right) {
        return left == right ? String.valueOf(left) : left + "->" + right;
    }
}