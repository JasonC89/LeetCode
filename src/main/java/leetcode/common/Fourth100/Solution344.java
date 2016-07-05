package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/4/16.
 * Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class Solution344 {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return sb.reverse().toString();
    }
}
