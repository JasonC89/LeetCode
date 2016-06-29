package leetcode.common.Over100;

/**
 * Created by Jason on 6/28/16.
 * Excel Sheet Column Number
 *
 * Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int result = 0;
        for (char digit : s.toCharArray()) {
            result *= 26;
            result += digit - 'A' + 1;
        }
        return result;
    }
}
