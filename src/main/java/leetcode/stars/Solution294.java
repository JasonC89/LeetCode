package leetcode.stars;

/**
 * Created by Jason on 6/12/16.
 * Flip Game II
 *
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters:
 * + and -, you and your friend take turns to flip two
 * consecutive "++" into "--". The game ends when a person
 * can no longer make a move and therefore the other person
 * will be the winner.

 Write a function to determine if the starting player can
 guarantee a win.

 For example, given s = "++++", return true. The starting
 player can guarantee a win by flipping the middle "++" to
 become "+--+".

 Follow up:
 Derive your algorithm's runtime complexity.
 */
public class Solution294 {

    private char[] array;

    public boolean canWin(String s) {
        array = s.toCharArray();
        return canWin();
    }

    private boolean canWin() {
        for (int is = 0; is <= array.length-2; ++is) {
            if (array[is] == '+' && array[is+1] == '+') {
                array[is] = '-'; array[is+1] = '-';
                boolean wins = !canWin();
                array[is] = '+'; array[is+1] = '+';
                if (wins) return true;
            }
        }
        return false;
    }
}
