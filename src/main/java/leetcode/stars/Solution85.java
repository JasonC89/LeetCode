package leetcode.stars;

import java.util.Stack;

/**
 * Created by hchang on 6/7/16.
 * Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = i==0? 1 : dp[i-1][j] + 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            Stack<Integer> stack = new Stack();
            for (int j = 0; j <= dp[i].length; j++) {
                int current = j == dp[i].length ? 0 : dp[i][j];
                while(!stack.isEmpty() && dp[i][stack.peek()] > current) {
                    int height = dp[i][stack.pop()];
                    result = Math.max(result, height * (stack.isEmpty()? j : j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        return result;
    }
}
