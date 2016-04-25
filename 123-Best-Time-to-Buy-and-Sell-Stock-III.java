public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) {
			return 0;
		}

		int n = prices.length;
		// from [0 - i] [i - (n -1)] max profit
		int[] left = new int[n];
		int[] right = new int[n];

		int min = prices[0]; // lowest buy in prices
		left[0] = 0; // the maxest profit before this day
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}

		int max = prices[n - 1]; // maxest sales prices
		right[n - 1] = 0;
		for (int i = n -2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < n; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
}