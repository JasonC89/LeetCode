package leetcode.common.Second100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] postorder, int postStart, int posrtEnd, int[] inorder, int inStart, int inEnd) {
        if (postStart > posrtEnd) {
            return null;
        }
        if (postStart == posrtEnd) {
            return new TreeNode(postorder[posrtEnd]);
        }

        int mid = postorder[posrtEnd];
        TreeNode root = new TreeNode(mid);
        int first = 0;
        int second = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == mid) {
                first = i - 1;
                second = i + 1;
                break;
            }
        }
        int size1 = first - inStart + 1;
        int size2 = inEnd - second + 1;
        if (size1 > 0) {
            root.left = build(postorder, postStart, postStart + size1 - 1, inorder, inStart, first);
        }
        if (size2 > 0) {
            root.right = build(postorder, posrtEnd - size2, posrtEnd-1, inorder, second, inEnd);
        }
        return root;
    }
}
