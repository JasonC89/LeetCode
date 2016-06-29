package leetcode.common.First100;

/**
 * Created by hchang on 6/21/16.
 * Reverse Integer
 *
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class Solution7 {
    public int reverse(int x) {
        boolean flag = true;
        long number = x;
        if (x < 0) {
            flag = false;
            number *= -1;
        }
        long result = 0;
        while(number > 0) {
            result = 10 * result + number % 10;
            number /= 10;
            if (flag && result > Integer.MAX_VALUE) {
                return 0;
            }
            if (!flag && result > -1 * (long)Integer.MIN_VALUE) {
                return 0;
            }
        }
        return flag ? (int) result : (int)(-1 * result);
    }
}
