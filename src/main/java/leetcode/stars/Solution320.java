package leetcode.stars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/14/16.
 * Generalized Abbreviation
 *
 * Write a function to generate the generalized abbreviations of a word.

 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 */
public class Solution320 {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList();
        helper(result, new StringBuilder(), word, 0, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder stringBuilder, String word, int position, int number) {
        if (position >= word.length()) {
            int length = stringBuilder.length();
            if (number > 0) {
                stringBuilder.append(String.valueOf(number));
            }
            result.add(stringBuilder.toString());
            stringBuilder.setLength(length);
        } else {
            helper(result, stringBuilder, word, position+1, number+1);
            int length = stringBuilder.length();
            if (number > 0) {
                stringBuilder.append(String.valueOf(number));
            }
            stringBuilder.append(String.valueOf(word.charAt(position)));
            helper(result, stringBuilder, word, position+1, 0);
            stringBuilder.setLength(length);
        }
    }
}
