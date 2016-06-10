package leetcode.stars;

/**
 * Created by hchang on 6/10/16.
 * Find Minimum in Rotated Sorted Array
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class Solution153 {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length-1);
    }

    private int find(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start-1) / 2;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        if (nums[start] <= nums[mid]) {
            return find(nums, mid+1, end);
        } else {
            return find(nums, start, mid);
        }
    }
}
