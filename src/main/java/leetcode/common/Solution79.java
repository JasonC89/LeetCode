package leetcode.common;

/**
 * Created by Jason on 6/25/16.
 * Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y) {
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        char current = board[x][y];
        board[x][y] = '.';
        for (int[] direction : directions) {
            if (dfs(board, word, index+1, x+direction[0], y+direction[1])) {
                return true;
            }
        }
        board[x][y] = current;
        return false;
    }
}
