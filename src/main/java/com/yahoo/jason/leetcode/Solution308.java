package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 6/2/16.
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 update(3, 2, 2)
 sumRegion(2, 1, 4, 3) -> 10
 Note:
 */
public class Solution308 {
    private int[][] values;
    private int[][] tree;
    public Solution308(int[][] matrix) {
        values = matrix;
        tree = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                addTree(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        addTree(row, col, val - values[row][col]);
        values[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2, col2) + query(row1-1, col1-1) - query(row2, col1-1) - query(row1-1, col2);
    }

    private void addTree(int x, int y, int value) {
        x++;
        y++;
        while(x <= values.length) {
            int y1 = y;
            while(y1 <= values[0].length) {
                tree[x][y1] += value;
                y1 += (y1 & -y1);
            }
            x += (x & -x);
        }
    }

    private int query(int x, int y) {
        x++;
        y++;
        int sum = 0;
        while(x > 0) {
            int y1 = y;
            while(y1 > 0) {
                sum += tree[x][y1];
                y1 -= (y1 & -y1);
            }
            x -= (x & -x);
        }
        return sum;
    }
}
