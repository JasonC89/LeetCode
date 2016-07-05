package leetcode.common.Fourth100;

import java.util.Arrays;

/**
 * Created by Jason on 7/4/16.
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] buy = new int[prices.length+1];
        int[] sell = new int[prices.length+1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, Integer.MIN_VALUE);
        buy[0] = 0;
        sell[0] = 0;
        buy[1] = -prices[0];
        sell[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i+1] = Math.max(sell[i-1] - prices[i], buy[i]);
            sell[i+1] = Math.max(buy[i+1] + prices[i], sell[i]);
        }

        return sell[prices.length];
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        solution309.maxProfit(new int[] {1,2,3,0,2});
    }
}
