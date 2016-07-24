public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int buy = Integer.MIN_VALUE;
        int prev_buy;
        int sell = 0;
        int prev_sell = 0;
        
        for(int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_buy, prev_sell - price);
            prev_sell = sell;
            sell = Math.max(prev_sell, buy + price);
        }
        
        return sell;
        
    }
}