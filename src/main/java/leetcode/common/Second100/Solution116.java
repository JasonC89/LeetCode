package leetcode.common.Second100;

import leetcode.stars.TreeLinkNode;

/**
 * Created by Jason on 6/26/16.
 * Populating Next Right Pointers in Each Node
 *
 * Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */
public class Solution116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = null;
        start = root;

        while(start != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode pre = null;
            while (start != null) {
                if (start.left != null) {
                    if (pre != null) {
                        pre.next = start.left;
                    }
                    if (nextLevel == null) {
                        nextLevel = start.left;
                    }
                    pre = start.left;
                }
                if (start.right != null) {
                    if (pre != null) {
                        pre.next = start.right;
                    }
                    if (nextLevel == null) {
                        nextLevel = start.right;
                    }
                    pre = start.right;
                }
                start = start.next;
            }
            start = nextLevel;
        }
    }
}
