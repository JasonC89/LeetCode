package leetcode.stars;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/11/16.
 *
 * Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 Hint:

 Try to utilize the property of a BST.
 What if you could modify the BST node's structure?
 The optimal runtime complexity is O(height of BST).
 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if (count == k-1) {
            return root.val;
        } else if (count > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k-count-1);
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        Solution230 solution230 = new Solution230();
        solution230.kthSmallest(root, 2);
    }
}
