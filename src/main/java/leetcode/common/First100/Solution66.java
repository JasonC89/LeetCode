package leetcode.common.First100;

/**
 * Created by Jason on 6/25/16.
 * Plus One
 *
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int index = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                index = i;
            }
        }
        if (index < 0) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        } else {
            digits[index]++;
            for (int i = index+1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        }
    }
}
