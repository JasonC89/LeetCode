package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Perfect Squares
 *
 * Given a positive integer n, find the least number of perfect
 * square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 given n = 13, return 2 because 13 = 4 + 9.


 */
public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int current = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                current = Math.min(current, 1+dp[i - j * j]);
            }
            dp[i] = current;
        }
        return dp[n];
    }
}
