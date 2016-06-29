package leetcode.common.First100;

/**
 * Created by hchang on 6/21/16.
 * Longest Palindromic Substring
 *
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String tmp = extend(s, i, i);
            if (result.length() < tmp.length()) {
                result = tmp;
            }
            tmp = extend(s, i, i+1);
            if (result.length() < tmp.length()) {
                result = tmp;
            }
        }
        return result;
    }

    private String extend(String s, int left, int right) {
        String result;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
