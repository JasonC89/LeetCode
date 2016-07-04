package leetcode.common.Third100;

import java.util.Arrays;

/**
 * Created by Jason on 7/2/16.
 * Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        return new String(array1).equals(new String(array2));
    }
}
