package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by Jason on 6/28/16.
 * Binary Search Tree Iterator
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class Solution173 {
    Stack<TreeNode> stack = new Stack();
    public Solution173(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int result = stack.peek().val;
        TreeNode node = stack.pop();
        node = node.right;
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        return result;
    }
}
