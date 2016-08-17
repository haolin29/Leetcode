public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            } 
            set.add(num);
        }
        
        return false;
    }
}