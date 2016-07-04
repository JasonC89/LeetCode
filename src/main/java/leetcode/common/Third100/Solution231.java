package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        while(n > 0) {
            if ((n & 1) == 1) {
                n >>= 1;
                if (n == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            n >>= 1;
        }
        return false;
    }
}
