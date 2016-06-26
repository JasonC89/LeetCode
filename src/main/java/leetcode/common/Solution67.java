package leetcode.common;

/**
 * Created by Jason on 6/25/16.
 * Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int index1 = a.length() - 1 - i;
            int index2 = b.length() - 1 - i;
            if (index1 >= 0) {
                carry += a.charAt(index1) - '0';
            }
            if (index2 >= 0) {
                carry += b.charAt(index2) - '0';
            }
            stringBuilder.append(String.valueOf(carry%2));
            carry /= 2;
        }
        if (carry > 0) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }
}
