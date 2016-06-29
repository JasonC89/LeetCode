package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Minimum Depth of Binary Tree
 *
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest
 path from the root node down to the nearest leaf node.
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
