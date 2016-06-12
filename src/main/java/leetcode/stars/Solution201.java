package leetcode.stars;

/**
 * Created by Jason on 6/11/16.
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647,
 * return the bitwise AND of all numbers in this range, inclusive.

 For example, given the range [5, 7], you should return 4.

 Credits:
 Special thanks to @amrsaqr for adding this problem and creating all test cases.
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int counter = 1;
        while(m != n) {
            m >>>= 1;
            n >>>= 1;
            counter <<= 1;
        }
        return m * counter;
    }
}
