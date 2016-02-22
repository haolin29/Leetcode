// decrease the range every iteration
// 

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            int[] a = {-1,-1};
            return a;
            
        }
        
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        
        // left bound
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target ) {
            result[0] = start;
        } else if (nums[end] == target){
            result[0] = end;
        } else {
            result[0] = result[1] = -1;
            return result;
        }
        
        // right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target ) {
            result[1] = end;
        } else if (nums[start] == target ){
            result[1] = start;
        } else {
            result[0] = result[1] = -1;
        }
        
        return result;
        
    }
}