package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/25/16.
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TreeNode tail = root.left;
            while(tail.right != null) {
                tail = tail.right;
            }
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            tail.right = tmp;
        }
        flatten(root.right);
    }
}
