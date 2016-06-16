package base.algo;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by hchang on 6/15/16.
 */
public class MorrisTraversal {
    void visit(TreeNode root) {

    }

    void inorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        while (cur != null)
        {
            if (cur.left == null)          // 1.
            {
                visit(cur);
                cur = cur.right;
            }
            else
            {
                // find predecessor
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null)   // 2.a)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else                       // 2.b)
                {
                    prev.right = null;
                    visit(cur);
                    cur = cur.right;
                }
            }
        }
    }

    void preorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        while (cur != null)
        {
            if (cur.left == null)
            {
                cur = cur.right;
            }
            else
            {
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null)
                {
                    visit(cur);  // the only difference with inorder-traversal
                    prev.right = cur;
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}

