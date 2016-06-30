package leetcode.common.First100;

/**
 * Created by hchang on 6/23/16.
 * Spiral Matrix II
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int index = 0;
        int[][] result = new int[n][n];
        int x = 0;
        int y = -1;
        for (int i = 1; i <= n * n; i++) {
            int newX = x + directions[index][0];
            int newY = y + directions[index][1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < n && result[newX][newY] == 0) {
                result[newX][newY] = i;
                x = newX;
                y = newY;
            } else {
                index = (index == 3? 0 : index+1);
                i--;
            }
        }
        return result;
    }
}
