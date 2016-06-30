package leetcode.common.Second100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/27/16.
 * Binary Tree Upside Down
 *
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
 / \
 3   1
 */
public class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
