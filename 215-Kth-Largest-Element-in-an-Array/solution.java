public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        return getKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int getKth(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        
        while(true) {
            while(left < right && nums[left] < pivot) {
                left++;
            }
            
            while(left < right && nums[right] >= pivot) {
                right--;
            }
            
            if(left == right) break;
            
            swap(nums, left, right);
        }
        
        // reset pivot 
        swap(nums, left, end);
        
        if(left + 1 == k) {
            return pivot;
        } else if (left + 1 > k) {
            return getKth(nums, start, left - 1, k);
        } else {
            return getKth(nums, left + 1, end ,k);
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}