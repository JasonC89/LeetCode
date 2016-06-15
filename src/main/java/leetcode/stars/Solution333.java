package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/14/16.
 * Largest BST Subtree
 *
 * Given a binary tree, find the largest subtree
 * which is a Binary Search Tree (BST), where largest
 * means subtree with largest number of nodes in it.

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
 */
public class Solution333 {
    private int result = 0;
    public int largestBSTSubtree(TreeNode root) {
        visit(root);
        return result;
    }

    private Result visit(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = visit(root.left);
        Result right = visit(root.right);
        if (left.size < 0
                || right.size < 0
                || root.val < left.max
                || root.val > right.min) {
            return new Result(-1, 0, 0);
        }

        result = Math.max(result, left.size+right.size+1);
        return new Result(left.size+right.size+1, Math.min(left.min, root.val), Math.max(right.max, root.val));
    }

    private class Result {
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
