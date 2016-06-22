package leetcode.common;

/**
 * Created by hchang on 6/21/16.
 * String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and a
 sk yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely
 (ie, no given input specs). You are responsible to gather
 all the input requirements up front.
 */
public class Solution8 {
    public int myAtoi(String str) {
        boolean flag = true;
        long result = 0;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') {
                flag = false;
            } else if (i == 0 && str.charAt(i) == '+') {
                flag = true;
            } else {
                if (Character.isDigit(str.charAt(i))) {
                    result = 10 * result + str.charAt(i) - '0';
                    if (flag && result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    if (!flag && result > -1 * (long) Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        return (int) (flag? result : -1 * result);
    }
}
