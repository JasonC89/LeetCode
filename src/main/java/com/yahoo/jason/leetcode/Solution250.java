package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/25/16.
 * Given a binary tree, count the number of uni-value subtrees.

 A Uni-value subtree means all nodes of the subtree have the same value.

 For example:
 Given binary tree,
 5
 / \
 1   5
 / \   \
 5   5   5
 return 4.
 */
public class Solution250 {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        count(root, count);
        return count[0];
    }

    private boolean count(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = count(node.left, count);
        boolean right = count(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
