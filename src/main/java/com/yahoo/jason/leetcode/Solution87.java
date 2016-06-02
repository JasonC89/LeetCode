package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/31/16.
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        boolean[][][] dp = new boolean[s1.length() + 1][s1.length()][s1.length()];
        for (int k = 1; k <= s1.length(); k++) {
            for (int i = 0; i <= s1.length() - k; i++) {
                for (int j = 0; j <= s1.length()-k; j++) {
                    if (k == 1) {
                        dp[k][i][j] = (s1.charAt(i) == s2.charAt(j));
                    } else {
                        for (int p = 1; p < k ; p++) {
                            dp[k][i][j] |= ((dp[p][i][j] && dp[k-p][i+p][j+p]) || (dp[p][i][j+k-p] && dp[k-p][i+p][j]));
                        }
                    }
                }
            }
        }
        return dp[s1.length()][0][0];
    }
}
