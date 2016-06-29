package leetcode.common.Over100;

import java.util.Arrays;

/**
 * Created by Jason on 6/28/16.
 * Best Time to Buy and Sell Stock IV
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        int[] buys = new int[k];
        int[] sells = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        Arrays.fill(sells, Integer.MIN_VALUE);

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buys[j] = Math.max(buys[j], 0 - prices[i]);
                } else {
                    buys[j] = Math.max(buys[j], sells[j-1] - prices[i]);
                }
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
            }
        }

        int result = 0;
        for (int sell : sells) {
            result = Math.max(result, sell);
        }
        return result;
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
