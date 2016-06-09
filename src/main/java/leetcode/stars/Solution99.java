package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by hchang on 6/7/16.
 *
 * Recover Binary Search Tree
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?
 */
public class Solution99 {

    private TreeNode pre;
    private TreeNode first;
    private TreeNode second;

    public void recoverTree(TreeNode root) {
        traversal(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void traversal(TreeNode root) {
        if (root.left != null) {
            traversal(root.left);
        }

        if (pre != null) {
            if (root.val < pre.val) {
                if (first == null) {
                    first = pre;
                    second = root;
                } else {
                    second = root;
                }
            }
        }
        pre = root;

        if (root.right != null) {
            traversal(root.right);
        }
    }
}
