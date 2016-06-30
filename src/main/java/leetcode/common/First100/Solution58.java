package leetcode.common.First100;

/**
 * Created by hchang on 6/23/16.
 * Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length-1].length();
    }
}
