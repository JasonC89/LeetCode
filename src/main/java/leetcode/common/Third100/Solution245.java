package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Shortest Word Distance III
 *
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 word1 and word2 may be the same and they represent two individual words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “makes”, word2 = “coding”, return 1.
 Given word1 = "makes", word2 = "makes", return 3.
 */
public class Solution245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (!word1.equals(word2)) {
                if (word1.equals(words[i])) {
                    index1 = i;
                }
                if (word2.equals(words[i])) {
                    index2 = i;
                }
            } else {
                if (word1.equals(words[i])) {
                    index1 = index2;
                    index2 = i;
                }
            }
            if (index1 >= 0 && index2 >= 0) {
                result = Math.min(result, Math.abs(index1-index2));
            }
        }
        return result;
    }
}
