package leetcode.common.Third100;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jason on 7/3/16.
 * Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 Hint:

 Consider the palindromes of odd vs even length. What difference do you notice?
 Count the frequency of each character.
 If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet();
        for (char cur : s.toCharArray()) {
            if (set.contains(cur)) {
                set.remove(cur);
            } else {
                set.add(cur);
            }
        }
        return set.size() < 2;
    }
}
