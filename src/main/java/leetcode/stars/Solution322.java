package leetcode.stars;

import java.util.Arrays;

/**
 * Created by hchang on 6/14/16.
 * Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up
 * that amount. If that amount of money cannot be made up by any combination of the coins,
 * return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(min, coin);
        }
        dp[0] = 0;
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] < Integer.MAX_VALUE) {
                    for (int coin : coins) {
                        if (j + coin <= amount) {
                            dp[j+coin] = Math.min(dp[j+coin], dp[j]+1);
                        }
                    }
                }
            }
        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }
}
