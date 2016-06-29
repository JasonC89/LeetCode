package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Flatten Binary Tree to Linked List
 *
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
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            TreeNode right = root.right;
            root.right = root.left;
            root.left = null;
            left.right = right;
        }
        flatten(root.right);
    }
}
