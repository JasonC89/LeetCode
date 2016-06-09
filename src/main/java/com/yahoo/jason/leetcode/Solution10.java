package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 6/2/16.
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        boolean dp[][] = new boolean[m][n];
        dp[0][0] = true;

        for (int i = 1; i < n; i++) {
            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != '.' && p.charAt(j-2) != s.charAt(i-1)) {
                        dp[i][j] = dp[i][j-2];
                    } else {
                        dp[i][j] = dp[i][j-1] || dp[i][j-2] || dp[i-1][j];
                    }
                } else {
                    dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        solution10.isMatch("ab", "a*");
    }
}
