package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/27/16.
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class Solution186 {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        swap(s, 0, s.length-1);
        int start = -2;
        int end = -2;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                start = end + 2;
                end = i - 1;
                swap(s, start, end);
            }
        }
        start = end + 2;
        end = s.length - 1;
        swap(s, start, end);
    }

    private void swap(char[] s, int start, int end) {
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
