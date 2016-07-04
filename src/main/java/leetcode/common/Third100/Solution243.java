package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Shortest Word Distance
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.


 */
public class Solution243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            }
            if (word2.equals(words[i])) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                result = Math.min(result, Math.abs(index1-index2));
            }
        }
        return result;
    }
}
