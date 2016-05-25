package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/25/16.
 * Given a binary tree, find the length of the longest consecutive sequence path.

 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

 For example,
   1
    \
     3
    / \
   2   4
        \
         5
 Longest consecutive sequence path is 3-4-5, so return 3.
    2
    \
    3
    /
    2
    /
    1
 Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class Solution298 {
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[]{0};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        if (root.left != null) {
            int mostLeft = helper(root.left, max);
            if (root.val == root.left.val - 1) {
                result = Math.max(result, mostLeft + 1);
            }
        }

        if (root.right != null) {
            int mostRight = helper(root.right, max);
            if (root.val == root.right.val - 1) {
                result = Math.max(result, mostRight + 1);
            }
        }
        max[0] = Math.max(max[0], result);
        return result;
    }
}
