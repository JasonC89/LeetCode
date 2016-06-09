package leetcode.stars;

/**
 * Created by hchang on 6/7/16.
 * Scramble String
 *
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
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }

        int length = s1.length();
        boolean [][][] dp = new boolean[length][length][length];
        for (int k = 1; k <= length; k++) {
            for (int i = 0; i <= length - k; i++) {
                for (int j = 0; j <= length - k; j++) {
                    if (k == 1) {
                        dp[k][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        if (s1.substring(i, i+k).equals(s2.substring(j, j+k))) {
                            dp[k][i][j] = true;
                        } else {
                            for (int z = 1; z < k; z++) {
                                if ((dp[z][i][j] && dp[k-z][i+z][j+z]) || (dp[z][i][j+k-z] && dp[k-z][i+z][j])) {
                                    dp[k][i][j] = true;
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        }
        return dp[length][0][0];
    }
}
