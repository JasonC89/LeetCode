package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart < preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int mid = preorder[preStart];
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
            root.left = build(preorder, preStart+1, preStart+size1, inorder, inStart, first);
        }
        if (size2 > 0) {
            root.right = build(preorder, preEnd - size2 + 1, preEnd, inorder, second, inEnd);
        }
        return root;
    }
}
