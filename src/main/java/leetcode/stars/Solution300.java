package leetcode.stars;

import java.util.Arrays;

/**
 * Created by Jason on 6/12/16.
 * Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?


 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, length, num);
            if (index < 0) {
                index = (index + 1) * -1;
            }
            dp[index] = num;
            if (index == length) {
                length++;
            }
        }
        return length;
    }
}
