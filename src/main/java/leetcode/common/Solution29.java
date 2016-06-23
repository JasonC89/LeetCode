package leetcode.common;

/**
 * Created by hchang on 6/22/16.
 * Divide Two Integers
 *
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean positive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            positive = true;
        }
        long divid = Math.abs((long) dividend);
        long divsor = Math.abs((long) divisor);
        long result = 0;
        while (divid >= divsor) {
            long tmp = divsor;
            long tmpResult = 1;
            while(tmp <= divid) {
                tmp <<= 1;
                tmpResult <<= 1;
            }
            result += tmpResult >> 1;
            divid -= tmp >> 1;
        }
        if ((positive && result > Integer.MAX_VALUE) || (!positive && result > (long)Integer.MAX_VALUE + 1)) {
            return Integer.MAX_VALUE;
        }
        return (int)(positive?result : -result);
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        solution29.divide(1, -1);
    }
}
