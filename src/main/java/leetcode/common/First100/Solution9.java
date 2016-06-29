package leetcode.common.First100;

/**
 * Created by hchang on 6/21/16.
 * Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int old = x;
        long reverse = 0;
        while(old > 0) {
            reverse = 10 * reverse + old % 10;
            old /= 10;
            if (reverse > Integer.MAX_VALUE) {
                return false;
            }
        }
        return reverse == x;
    }
}
