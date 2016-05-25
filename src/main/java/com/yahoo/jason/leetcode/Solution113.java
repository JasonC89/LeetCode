package com.yahoo.jason.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 5/25/16.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> current = new ArrayList();
        pathSum(root, sum, result, current);
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> current) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            current.add(sum);
            result.add(new ArrayList(current));
            current.remove(current.size()-1);
            return;
        }
        current.add(root.val);
        if (root.left != null) {
            pathSum(root.left, sum - root.val, result, current);
        }
        if (root.right != null) {
            pathSum(root.right, sum - root.val, result, current);
        }
        current.remove(current.size()-1);
    }
}
