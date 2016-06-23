package leetcode.common;

/**
 * Created by hchang on 6/22/16.
 * Search for a Range
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = helper(nums, target - 0.5, 0, nums.length-1);
        int right = helper(nums, target + 0.5, 0, nums.length-1);
        if (left >= 0 && right >= 0 && left < right) {
            return new int[] {left, right-1};
        }
        return new int[] {-1, -1};
    }

    private int helper(int[] nums, double target, int start, int end) {
        if (start == end) {
            if (nums[start] > target) {
                return start;
            }
            return start + 1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) {
            return helper(nums, target, mid+1, end);
        } else {
            return helper(nums, target, start, mid);
        }
    }
}
