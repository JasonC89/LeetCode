package leetcode.common.First100;

/**
 * Created by hchang on 6/24/16.
 * Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = dp[i][j];
                if (i > 0) {
                    sum += dp[i-1][j];
                }
                if (j > 0) {
                    sum += dp[i][j-1];
                }
                dp[i][j] = sum;
            }
        }
        return dp[m-1][n-1];
    }
}
