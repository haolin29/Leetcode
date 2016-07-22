public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) {
            return -1;
        }
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // defination
        int[][] dp = new int[m][n]; // the minimum heatlh point entering the room, minimum number should be 1 point
        
        // transfer function
        // f[i][j] = max(1, -dungeon[i][j] + min(dp[i+1][j], dp[i][j + 1]));
        dp[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);
        
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, -dungeon[i][n - 1] + dp[i + 1][n - 1]);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, -dungeon[m - 1][i] + dp[m - 1][i + 1]);
        }
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, -dungeon[i][j] + Math.min(dp[i+1][j], dp[i][j+1]));
            }
        }
        
        return dp[0][0];
        
    }
}