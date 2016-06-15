package leetcode.stars;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by hchang on 6/14/16.
 * Maximum Product of Word Lengths
 *
 * Given a string array words, find the maximum value of length(word[i])
 * * length(word[j]) where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.

 Example 1:
 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 2:
 Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 Return 4
 The two words can be "ab", "cd".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.
 */
public class Solution318 {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char mychar : words[i].toCharArray()) {
                mask[i] |= (1<<(mychar-'a'));
            }
        }
        int max = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i ; j < words.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
