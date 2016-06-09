package leetcode.stars;

/**
 * Created by hchang on 6/7/16.
 * Distinct Subsequences
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 A subsequence of a string is a new string which is formed from the
 original string by deleting some (can be none) of the characters without
 disturbing the relative positions of the remaining characters.
 (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 Here is an example:
 S = "rabbbit", T = "rabbit"

 Return 3.
 */
public class Solution115 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j+1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
