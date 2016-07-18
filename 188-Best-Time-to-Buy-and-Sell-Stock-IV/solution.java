public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        if (k > prices.length) return maxProfit(prices);
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(0,profit), local[j] + profit );
                global[j] = Math.max(local[j], global[j]);
            }
            
        }
        
        return global[k];
        
    }
    
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return max;
    }
}