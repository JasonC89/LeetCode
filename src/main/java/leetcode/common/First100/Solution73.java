package leetcode.common.First100;

/**
 * Created by Jason on 6/25/16.
 * Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0,
 * set its entire row and column to 0. Do it in place.
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean column = false;
        for(int i = 0; i < m; i++) {
           if (matrix[i][0] == 0) {
               column = true;
               break;
           }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row) {
            for (int i = 1; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (column) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (row || column) {
            matrix[0][0] = 0;
        }
    }
}
