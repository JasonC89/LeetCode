package com.yahoo.jason.leetcode;

import java.util.Set;

/**
 * Created by hchang on 6/1/16.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] |= (dp[j] && wordDict.contains(s.substring(j, i)));
            }
        }
        return dp[s.length()];
    }
}
