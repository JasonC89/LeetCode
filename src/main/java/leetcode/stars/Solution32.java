package leetcode.stars;

import java.util.Stack;

/**
 * Created by hchang on 6/7/16.
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()",
 which has length = 4.
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty() || s.charAt(stack.peek()) != '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }

        int result = Integer.MIN_VALUE;
        int last = s.length();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            result = Math.max(last-current-1, result);
            last = current;
        }
        result = Math.max(last, result);
        return result;
    }

    public int dp(String s) {
        if(s.length() <= 1) return 0;
        int curMax = 0;
        int[] longest = new int[s.length()];
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    longest[i] = (i-2) >= 0 ? (longest[i-2] + 2) : 2;
                    curMax = Math.max(longest[i],curMax);
                }
                else{ // if s[i-1] == ')', combine the previous length.
                    if(i-longest[i-1]-1 >= 0 && s.charAt(i-longest[i-1]-1) == '('){
                        longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
                        curMax = Math.max(longest[i],curMax);
                    }
                }
            }
            //else if s[i] == '(', skip it, because longest[i] must be 0
        }
        return curMax;
    }
}
