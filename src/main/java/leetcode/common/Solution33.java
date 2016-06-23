package leetcode.common;

/**
 * Created by hchang on 6/22/16.
 * Search in Rotated Sorted Array
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[start] <= nums[mid]) {
            if (target >= nums[start] && target < nums[mid]) {
                return helper(nums, target, start, mid);
            } else {
                return helper(nums, target, mid+1, end);
            }
        } else {
            if (target < nums[mid] || target >= nums[start]) {
                return helper(nums, target, start, mid);
            } else {
                return helper(nums, target, mid+1, end);
            }
        }
    }
}
