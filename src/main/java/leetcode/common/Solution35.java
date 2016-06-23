package leetcode.common;

/**
 * Created by Jason on 6/22/16.
 * Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] >= target) {
                return start;
            }
            return start+1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return search(nums, target, start, mid);
        } else {
            return search(nums, target, mid+1, end);
        }

    }
}
