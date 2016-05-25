package com.yahoo.jason.leetcode;

/**
 * Created by hchang on 5/25/16.
 */

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution108 {
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (start == end - 1) {
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid+1, end);
        return root;
    }

 }
