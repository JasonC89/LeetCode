package leetcode.common.First100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        while(left != null && left.right != null) {
            left = left.right;
        }
        if (left != null && left.val >= root.val) {
            return false;
        }

        TreeNode right = root.right;
        while(right != null && right.left != null) {
            right = right.left;
        }
        if (right != null && right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
