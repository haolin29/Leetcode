public class Solution {
    // key point: the min price before the day
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        
        int n = prices.length;
        int min = prices[0];
        int max = 0;
        
        for(int i = 1; i < n; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i],min);
        }
        
        return max;
        
        
    }
}