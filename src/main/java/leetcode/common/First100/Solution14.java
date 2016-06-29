package leetcode.common.First100;

/**
 * Created by hchang on 6/21/16.
 * Longest Common Prefix
 *
 *Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        boolean same = true;
        while(same) {
            if (i < strs[0].length()) {
                char current = strs[0].charAt(i);
                for (String str : strs) {
                    if (str == null || i >= str.length()||current != str.charAt(i)) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    builder.append(current);
                }
            } else {
                same = false;
            }
        }
        return builder.toString();
    }
}
