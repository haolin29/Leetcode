public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        if(numbers == null || numbers.length == 0) {
            return result;
        }
        
        int start = 0;
        int end = numbers.length - 1;
        
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            
            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        
        return result;
    }
}