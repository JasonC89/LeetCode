package com.yahoo.jason.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 5/31/16.
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        boolean[][] current = new boolean[n][n];
        dfs(result, current, n);
        return result;
    }

    private void dfs(List<List<String>> result, boolean[][] current, int n) {
        if (n == 0) {
            List<String> list = new ArrayList<String>();
            for (boolean[] row : current) {
                StringBuilder stringBuilder = new StringBuilder();
                for (boolean bit : row) {
                    if (bit) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
        }
        for (int i = 0; i < current.length; i++) {
            if (valid(current, current.length-n, i)) {
                current[current.length-n][i] = true;
                dfs(result, current, n-1);
                current[current.length-n][i] = false;
            }
        }
    }

    private boolean valid(boolean[][] current, int x, int y) {
        int[][] directions = new int[][]{{-1,1}, {-1,-1}};
        for (int i = 0; i < x; i++) {
            if (current[i][y]) {
                return false;
            }
        }
        for (int[] direction : directions) {
            int i = x;
            int j = y;
            while (i >= 0 && i < current.length && j >= 0 && j < current.length) {
                if (current[i][j]) {
                    return false;
                }
                i += direction[0];
                j += direction[1];
            }
        }
        return true;
    }

    static public void main(String[] args) {
        Solution51 solution51 = new Solution51();
        solution51.solveNQueens(1);
    }
}
