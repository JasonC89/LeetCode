package leetcode.common.Fourth100;

import java.util.Arrays;

/**
 * Created by Jason on 7/4/16.
 * Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".
 */
public class Solution345 {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] array = s.toCharArray();
        char[] vowels = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        while (left < right) {
            while (left < right) {
                if (Arrays.binarySearch(vowels, array[left]) >= 0) {
                    break;
                }
                left++;
            }

            while (left < right) {
                if (Arrays.binarySearch(vowels, array[right]) >= 0) {
                    break;
                }
                right--;
            }

            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
        return new String(array);
    }
}
