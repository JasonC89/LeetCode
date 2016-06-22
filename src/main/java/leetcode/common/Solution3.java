package leetcode.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hchang on 6/21/16.
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        Set<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (set.contains(current)) {
                while(set.contains(current)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(current);
            result = Math.max(result, set.size());
        }
        return result;
    }
}
