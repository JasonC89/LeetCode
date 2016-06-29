package leetcode.common.Over100;

/**
 * Created by Jason on 6/28/16.
 * Reverse Words in a String II
 *
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class Solution186 {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, left, i - 1);
                left = i + 1;
            }
        }
        reverse(s, left, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
