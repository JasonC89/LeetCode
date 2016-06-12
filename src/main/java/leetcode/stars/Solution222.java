package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/11/16.
 * Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last,
 is completely filled, and all nodes in the last level are as far
 left as possible. It can have between 1 and 2h nodes inclusive at
 the last level h.
 */
public class Solution222 {
    public int countNodes(TreeNode root) {
        int result = 0;
        int height = height(root);
        while(root != null) {
            if (height(root.right) == height - 1) {
                result += 1 << height;
                root = root.right;
            } else {
                result += 1 << (height - 1);
                root = root.left;
            }
            height--;
        }
        return result;
    }

    private int height(TreeNode root) {
        return root == null ? -1 : height(root.left) + 1;
    }
}
