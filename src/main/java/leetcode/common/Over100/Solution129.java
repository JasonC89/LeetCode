package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/27/16.
 * Sum Root to Leaf Numbers
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> total = new ArrayList();
        helper(root, 0, total);
        int result = 0;
        for (int number : total) {
            result += number;
        }
        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> total) {
        if (root.left == null && root.right == null) {
            total.add(10 * sum + root.val);
            return;
        }
        if (root.left != null) {
            helper(root.left, 10 * sum + root.val, total);
        }
        if (root.right != null) {
            helper(root.right, 10 * sum + root.val, total);
        }
    }
}
