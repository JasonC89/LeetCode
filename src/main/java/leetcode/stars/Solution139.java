package leetcode.stars;

import java.util.Set;

/**
 * Created by hchang on 6/9/16.
 * Word Break
 *
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution139 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = wordDict.contains(s.substring(0, i+1));
            for (int j = i-1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j+1, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
