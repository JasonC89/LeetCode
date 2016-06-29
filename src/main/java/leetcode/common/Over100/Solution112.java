package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Path Sum
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return valid(root, 0, sum);
    }

    private boolean valid(TreeNode root, int current, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return current+root.val == target;
        }
        return valid(root.left, current+root.val, target)
                || valid(root.right, current+root.val, target);
    }
}
