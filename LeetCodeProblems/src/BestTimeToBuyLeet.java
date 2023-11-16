import java.util.Iterator;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 26, 2023
 */
public class BestTimeToBuyLeet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[] { 2, 4, 1 };
		System.out.println(maxProfit(prices));
		;
	}

	public static int maxProfit(int[] prices) {

		// has to be after buy date, want val to be high. sell val

		// variables outside loop so they don't reset
		// we don't need to store a high value, as we can only sell after we buy, so
		// that can reset
		int profit = 0;
		int ifSoldToday = 0;
		int low = Integer.MAX_VALUE; // buy value

		// loop through array find lowest ,then find next highest value after i
		for (int i = 0; i <= prices.length - 1; i++) {
			// if val of i < low value or is the first index then set our low val
			if (prices[i] < low) {
				low = prices[i];
			}
			ifSoldToday = prices[i] - low;
			// if val of i - low is greater than current profit, set profit
			if (ifSoldToday > profit) {
				profit = ifSoldToday;
			}
		}

		return profit;

	}

}

/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 */

//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.