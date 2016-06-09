package leetcode.stars;

/**
 * Created by hchang on 6/8/16.
 *
 * Populating Next Right Pointers in Each Node II
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
public class Solution117 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = null;
        start = root;

        while(start != null) {
            TreeLinkNode nextLevel = null;
            TreeLinkNode pre = null;
            while(start != null) {
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
