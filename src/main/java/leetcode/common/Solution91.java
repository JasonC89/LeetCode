package leetcode.common;

/**
 * Created by Jason on 6/25/16.
 * Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2.
 */
public class Solution91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        int pre_1_cnt = 1;
        int pre_2_cnt = 1;
        int cur_cnt = 1;

        for (int i = 1; i < s.length(); i++) {
            cur_cnt = 0;
            int num1 = Integer.valueOf(s.substring(i, i+1));
            int num2 = Integer.valueOf(s.substring(i-1, i+1));
            if (num1 > 0) {
                cur_cnt += pre_1_cnt;
            }
            if (num2 >= 10 && num2 <= 26) {
                cur_cnt += pre_2_cnt;
            }
            pre_2_cnt = pre_1_cnt;
            pre_1_cnt = cur_cnt;
        }
        return cur_cnt;
    }
}
