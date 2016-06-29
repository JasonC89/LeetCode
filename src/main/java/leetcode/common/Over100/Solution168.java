package leetcode.common.Over100;

/**
 * Created by Jason on 6/28/16.
 * Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class Solution168 {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n/26) + (char)('A' + n%26);
    }
}
