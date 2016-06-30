package leetcode.common.Second100;

/**
 * Created by Jason on 6/28/16.
 * Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 */
public class Solution172 {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + trailingZeroes(n/5);
    }
}
