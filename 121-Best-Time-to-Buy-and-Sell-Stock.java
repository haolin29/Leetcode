public class Solution {
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			min = min > prices[i] ? prices[i] : min;
			profit = Math.max(profit, prices[i] - min);
		}

		return profit;
	}
}