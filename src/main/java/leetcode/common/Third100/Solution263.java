package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Ugly Number
 *
 * Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 */
public class Solution263 {
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }

        if (num % 2 == 0) {
            return isUgly(num/2);
        } else if (num % 3 == 0) {
            return isUgly(num/3);
        } else if (num % 5 == 0) {
            return isUgly(num/5);
        } else {
            return false;
        }
    }
}
