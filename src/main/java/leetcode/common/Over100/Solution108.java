package leetcode.common.Over100;

import com.yahoo.jason.leetcode.TreeNode;

/**
 * Created by Jason on 6/26/16.
 * Convert Sorted Array to Binary Search Tree
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(nums[start]);
        } else {
            int mid = start + (end - start)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums, start, mid-1);
            root.right = build(nums, mid+1, end);
            return root;
        }
    }
}
