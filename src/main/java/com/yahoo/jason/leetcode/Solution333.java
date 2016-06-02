package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 6/1/16.
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

 Note:
 A subtree must include all of its descendants.
 Here's an example:
 10
 / \
 5  15
 / \   \
 1   8   7
 The Largest BST Subtree in this case is the highlighted one.
 The return value is the subtree's size, which is 3.
 Hint:

 You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
 Follow up:
 Can you figure out ways to solve it with O(n) time complexity?
 */
public class Solution333 {
    private int result = 0;
    public int largestBSTSubtree(TreeNode root) {
        traversal(root);
        return result;
    }

    private Result traversal(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = traversal(root.left);
        Result right = traversal(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.max || root.val >= right.min) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        this.result = Math.max(this.result, size);
        return new Result(size, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }

    private class Result{
        public int size;
        public int min;
        public int max;
        public Result(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
