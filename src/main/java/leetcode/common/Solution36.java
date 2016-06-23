package leetcode.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jason on 6/22/16.
 * Valid Sudoku
 *
 * Determine if a Sudoku is valid, according to:
 * Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled,
 where empty cells are filled with the character '.'.
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!helper(board, i, i, 0, 8) || !helper(board, 0, 8, i, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if (!helper(board, i, i+2, j, j+2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(char[][] board, int startX, int endX, int startY, int endY) {
        Set<Character> visited = new HashSet();
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (board[i][j] != '.') {
                    if (visited.contains(board[i][j])) {
                        return false;
                    }
                    visited.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
