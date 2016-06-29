package leetcode.common.First100;

/**
 * Created by Jason on 6/25/16.
 * Search in Rotated Sorted Array II
 *
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 Show Tags
 Show Similar Problems

 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return true; //return m in Search in Rotated Array I
            if (nums[l] < nums[m]) { //left half is sorted
                if (nums[l] <= target && target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (nums[l] > nums[m]) { //right half is sorted
                if (nums[m] < target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else l++;
        }
        return false;
    }
}
