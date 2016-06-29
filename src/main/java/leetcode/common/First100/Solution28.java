package leetcode.common.First100;

/**
 * Created by hchang on 6/22/16.
 * Implement strStr()
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean diff = false;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    diff = true;
                    break;
                }
            }
            if (!diff) {
                return i;
            }
        }
        return -1;
    }
}
