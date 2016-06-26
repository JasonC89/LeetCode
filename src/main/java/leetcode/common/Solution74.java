package leetcode.common;

/**
 * Created by Jason on 6/25/16.
 * Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int end = matrix.length * matrix[0].length;
        return search(matrix, target, 0, end-1);
    }

    private boolean search(int[][] matrix, int target, int start, int end) {
        if (start == end) {
            int x = start / matrix[0].length;
            int y = start % matrix[0].length;
            return matrix[x][y] == target;
        }

        int mid = start + (end - start) / 2;
        int x = mid / matrix[0].length;
        int y = mid % matrix[0].length;
        if (matrix[x][y] == target) {
            return true;
        } else if (matrix[x][y] > target) {
            return search(matrix, target, start, mid);
        } else {
            return search(matrix, target, mid + 1, end);
        }
    }
}
