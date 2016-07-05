package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/5/16.
 * Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True
 Example 2:

 Input: 14
 Returns: False
 */
public class Solution367 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long result = (long)mid * (long)mid;
            if (result == num) {
                return true;
            } else if (result < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
