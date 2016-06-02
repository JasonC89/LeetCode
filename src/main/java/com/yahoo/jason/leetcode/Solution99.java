package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/31/16.
 * Two elements of a binary search tree (BST) are swapped by mistake.

 Recover the tree without changing its structure.

 Note:
 A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Solution99 {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;

        while(root != null) {
            if (root.left == null) {
                if (pre != null && pre.val > root.val) {
                    if (first == null) {
                        first = pre;
                        second = root;
                    } else {
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            } else {
                TreeNode tmp = root.left;
                while(tmp.right != null && tmp.right != root) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = root;
                    root = root.left;
                } else {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) {
                            first = pre;
                            second = root;
                        } else {
                            second = root;
                        }
                    }
                    pre = root;
                    tmp.right = null;
                    root = root.right;
                }
            }
        }
        if(first!= null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
