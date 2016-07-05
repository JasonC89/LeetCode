package leetcode.common.Third100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 7/3/16.
 * Binary Tree Longest Consecutive Sequence
 *
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

    private int result = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return result;
        }
        dfs(root, new int[]{1});
        return result;
    }

    private void dfs(TreeNode root, int[] sum) {
        int old = sum[0];
        if (root.left != null) {
            if (root.left.val-1 == root.val) {
                sum[0] = old + 1;
            } else {
                sum[0] = 1;
            }
            this.result = Math.max(this.result, sum[0]);
            dfs(root.left, sum);
            sum[0] = old;
        }
        if (root.right != null) {
            if (root.right.val-1 == root.val) {
                sum[0] = old + 1;
            } else {
                sum[0] = 1;
            }
            this.result = Math.max(this.result, sum[0]);
            dfs(root.right, sum);
            sum[0] = old;
        }
    }
}
