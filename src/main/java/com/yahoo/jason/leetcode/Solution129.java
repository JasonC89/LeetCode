package com.yahoo.jason.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 5/27/16.
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
        List<Integer> list = new ArrayList();
        helper(list, 0, root);
        int result = 0;
        for (int num : list) {
            result += num;
        }
        return result;
    }

    private void helper(List<Integer> result, int current, TreeNode root) {
        if (root.left == null && root.right == null) {
            result.add(10 * current + root.val);
            return;
        }
        current = 10 * current + root.val;
        if (root.left != null) {
            helper(result, current, root.left);
        }
        if (root.right != null) {
            helper(result, current, root.right);
        }
    }
}
