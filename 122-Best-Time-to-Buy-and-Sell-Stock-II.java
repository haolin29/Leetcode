import java.io.*;
import java.util.*;
import java.math.*;

public class 122-Best-Time-to-Buy-and-Sell-Stock-II {
	// as many transaction as you like
	public static int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}

		return profit;

	}

	public static void main(String[] args) {
		int[] prices = new int[]{1,2,3,4,3,1,2,5};
		int profit = maxProfit(prices);
		return profit;

	}
}