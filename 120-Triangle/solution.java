public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.get(0).size() == 0) return -1;
        
        int dp[] = new int[triangle.size() + 1];
        
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }
}