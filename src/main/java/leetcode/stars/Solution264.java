package leetcode.stars;

/**
 * Created by Jason on 6/12/16.
 * Ugly Number II
 *
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            int number = Math.min(2*dp[index2], Math.min(3*dp[index3], 5*dp[index5]));
            dp[i] = number;
            if (number == 2*dp[index2]) {
                index2++;
            }
            if (number == 3*dp[index3]) {
                index3++;
            }
            if (number == 5*dp[index5]) {
                index5++;
            }
        }
        return dp[n-1];
    }
}
