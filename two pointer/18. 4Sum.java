// you should taking care about all duplication cases.

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // case 1
            if (i != 0 && nums[i] == nums[i - 1] ) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // case 2
                if (j != i + 1 && nums[j] == nums[j - 1] ) continue;
                int p1 = j + 1;
                int p2 = nums.length - 1;
                int find = target - nums[i] - nums[j];
                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == find) {
                        result.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[p1],nums[p2])));
                        p1++; 
                        p2--;
                        // case 3
                        while (p1 < p2 && nums[p1 - 1] == nums[p1]) p1++;
                        // case 4
                        while (p1 < p2 && nums[p2 + 1] == nums[p2]) p2--;
                    } else if (nums[p1] + nums[p2] < find) {
                        p1++;
                    } else {
                        p2--;
                    }
                    
                }
            }
        }
        
        return result;
        
    }
}