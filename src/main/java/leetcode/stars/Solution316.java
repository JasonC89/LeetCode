package leetcode.stars;

/**
 * Created by hchang on 6/14/16.
 * Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once
 * and only once. You must make sure your result is the smallest
 * in lexicographical order among all possible results.

 Example:
 Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"


 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        int index = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) <  s.charAt(index)) {
                index = i;
            }
            array[s.charAt(i)-'a']--;
            if (array[s.charAt(i)-'a'] == 0) {
                break;
            }
        }
        char current = s.charAt(index);
        return String.valueOf(current) + removeDuplicateLetters(s.substring(index+1).replaceAll("" + current, ""));
    }
}
