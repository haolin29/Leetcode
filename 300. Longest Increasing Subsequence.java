
// O(n ^ 2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}

// O(nlogn) 
// 
// maintain a tail array 
// 
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int n = nums.length;
        int[] dp = new int[n];
        
        // dp[i]表示长度为i的升序序列其末尾的数字
        dp[0] = nums[0];
        int len = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < dp[0]) {
                dp[0] = nums[i];
            } else if (nums[i] >= dp[len] ) {
                dp[++len] = nums[i];
            } else {
                dp[binarySearch(dp,0,len,nums[i])] = nums[i];
            }
        }

        return len + 1;
    }

    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
}
