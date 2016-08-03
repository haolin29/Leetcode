public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums) {
            heap.offer(num);
        }
        
        for(int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        
        return heap.poll();
    }
}