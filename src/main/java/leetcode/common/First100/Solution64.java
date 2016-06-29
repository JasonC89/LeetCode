package leetcode.common.First100;

/**
 * Created by Jason on 6/25/16.
 * Minimum Path Sum
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for (int i = 0; i <= grid.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= grid[0].length; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
