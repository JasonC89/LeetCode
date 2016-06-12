package leetcode.stars;

/**
 * Created by Jason on 6/11/16.
 * Shortest Palindrome
 *
 * Given a string S, you are allowed to convert
 * it to a palindrome by adding characters in front
 * of it. Find and return the shortest palindrome
 * you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    static public void main(String[] args) {
        Solution214 solution214 = new Solution214();
        String result = solution214.shortestPalindrome("abcdecba");
        System.out.println(result);
    }
}
