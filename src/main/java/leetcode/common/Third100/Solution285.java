package leetcode.common.Third100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 7/3/16.
 * Inorder Successor in BST
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

 Note: If the given node has no in-order successor in the tree, return null.
 */
public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while(root!=null) {
            if(root.val > p.val) {
                result = root;
                root = root.left;
            }
            else root = root.right;
        }
        return result;
    }
}
