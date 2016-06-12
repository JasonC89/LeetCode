package leetcode.stars;

import java.util.Stack;

/**
 * Created by Jason on 6/12/16.
 * Verify Preorder Sequence in Binary Search Tree
 *
 * Given an array of numbers, verify whether it is
 * the correct preorder traversal sequence of a binary
 * search tree.

 You may assume each number in the sequence is unique.

 Follow up:
 Could you do it using only constant space complexity?
 */
public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int last = Integer.MIN_VALUE;

        for (int num : preorder) {
            if (num < last) {
                return false;
            }
            while(!stack.isEmpty() && stack.peek() < num) {
                last = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
