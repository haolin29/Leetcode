public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        
        for(int num : nums) {
            heap.offer(num);
            
            if(heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.peek();
    }
}