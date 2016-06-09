package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by hchang on 6/8/16.
 * Binary Tree Maximum Path Sum
 *
 * Given a binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes
 from some starting node to any node in the tree along the parent-child connections.
 The path does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.
 */
public class Solution124 {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        path(root, result);
        return result[0];
    }

    private int path(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, path(root.left, result));
        int right = Math.max(0,path(root.right, result));
        result[0] = Math.max(result[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
