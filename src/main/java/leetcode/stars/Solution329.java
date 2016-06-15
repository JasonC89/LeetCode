package leetcode.stars;

/**
 * Created by hchang on 6/14/16.
 * Longest Increasing Path in a Matrix
 *
 * Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions:
 left, right, up or down. You may NOT move diagonally or move outside
 of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, dfs(matrix, i , j, dp));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] dp) {
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        int max = 0;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < dp.length && newY >= 0 && newY < dp[0].length && matrix[newX][newY] > matrix[x][y]) {
                max = Math.max(max, dfs(matrix, newX, newY, dp));
            }
        }
        dp[x][y] = max+1;
        return dp[x][y];
    }
}
