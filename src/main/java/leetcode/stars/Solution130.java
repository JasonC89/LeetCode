package leetcode.stars;

/**
 * Created by hchang on 6/8/16.
 * Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class Solution130 {
    private int[] parents;
    private int[] ranks;

    public void solve(char[][] board) {
        int total = board.length * board[0].length;
        parents = new int[total + 1];
        ranks = new int[total + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int index = i * board[0].length + j;
                parents[index] = index;
                ranks[index] = 1;
            }
        }
        parents[total] = total;
        ranks[total] = 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int index = i * board[0].length + j;
                if (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) {
                    union(index, total);
                }
                if (i > 0 && board[i-1][j] == 'O') {
                    union(index, (i-1) * board[0].length + j);
                }
                if (j > 0 && board[i][j-1] == 'O') {
                    union(index, i * board[0].length + j - 1);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int index = i * board[0].length + j;
                if (find(index) != find(total)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int i) {
        int index = i;
        while (index != parents[index]) {
            index = parents[index];
        }
        parents[i] = index;
        return index;
    }

    private boolean union(int i1, int i2) {
        int parent1 = find(i1);
        int parent2 = find(i2);
        if (parent1 == parent2) {
            return false;
        }
        if (ranks[parent1] >= ranks[parent2]) {
            parents[parent2] = parent1;
            ranks[parent1] += ranks[parent2];
        } else {
            parents[parent1] = parent2;
            ranks[parent2] += ranks[parent1];
        }
        return true;
    }
}
