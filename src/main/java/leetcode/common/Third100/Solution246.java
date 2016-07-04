package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        while (left < right) {
            char lChar = num.charAt(left);
            char rChar = num.charAt(right);
            if ((lChar == '9' && rChar == '6')
                    || (lChar == '6' && rChar == '9')
                    || (lChar == '8' && rChar == '8')
                    || (lChar == '1' && rChar == '1')
                    || (lChar == '0' && rChar == '0')) {

            } else {
                return false;
            }
            left++;
            right--;
        }
        if (left == right) {
            return (num.charAt(left) == '0' || num.charAt(left) == '1' || num.charAt(left) == '8');
        }
        return true;
    }
}
