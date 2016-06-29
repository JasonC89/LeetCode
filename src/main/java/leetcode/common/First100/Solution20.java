package leetcode.common.First100;

import java.util.Stack;

/**
 * Created by Jason on 6/21/16.
 * Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char current : s.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (current == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                } else if (current == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                } else if (current == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
