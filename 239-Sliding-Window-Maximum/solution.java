public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for(int i = 0; i < n; i++) {
            // remove old
            if(i >= k) {
                heap.remove(nums[i - k]);
            }
            // add new 
            heap.offer(nums[i]);
            if(i + 1 >= k) result[i - k + 1] = heap.peek();
            
        }
        
        return result;
    }
}