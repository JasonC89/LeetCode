package leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/21/16.
 * Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        String[] board = new String[]{"abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList();
        helper(result, new StringBuilder(), board, digits, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder stringBuilder, String[] board, String digits, int index) {
        if (index >= digits.length()) {
            if (stringBuilder.length() > 0) {
                result.add(stringBuilder.toString());
            }
            return;
        }
        int current = digits.charAt(index) - '2';
        if (current >= 0) {
            int length = stringBuilder.length();
            for (char currentChar : board[current].toCharArray()) {
                stringBuilder.append(currentChar);
                helper(result,stringBuilder,board,digits,index+1);
                stringBuilder.setLength(length);
            }
        } else {
            helper(result,stringBuilder,board,digits,index+1);
        }
    }


}
