package leetcode.stars;

/**
 * Created by hchang on 6/10/16.
 * Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index
 to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element
 and your function should return the index number 2.

 click to show spoilers.

 Note:
 Your solution should be in logarithmic complexity.
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                left = mid2;
            } else {
                right = mid1;
            }
        }
        return left;
    }
}
