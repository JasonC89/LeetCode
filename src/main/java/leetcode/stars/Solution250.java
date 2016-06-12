package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/12/16.
 * Count Univalue Subtrees
 *
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
        if (root == null) {
            return 0;
        }
        int[] result = new int[]{1};
        helper(root, result);
        return result[0];
    }

    private Integer helper(TreeNode root, int[] result) {
        Integer left = root.val;
        Integer right = root.val;
        if (root.left != null) {
            left = helper(root.left, result);
        }
        if (root.right != null) {
            right = helper(root.right, result);
        }
        if (left != null && right != null && left == right && left == root.val) {
            result[0]++;
            return root.val;
        }
        return null;
    }
}
