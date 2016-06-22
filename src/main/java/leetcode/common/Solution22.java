package leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/21/16.
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        helper(n, n, new StringBuilder(), result);
        return result;
    }

    private void helper(int left, int right, StringBuilder stringBuilder, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        int length = stringBuilder.length();
        if (left > 0) {
            stringBuilder.append("(");
            helper(left-1, right, stringBuilder, result);
            stringBuilder.setLength(length);
        }
        if (right > left) {
            stringBuilder.append(")");
            helper(left, right-1, stringBuilder, result);
            stringBuilder.setLength(length);
        }
    }
}
