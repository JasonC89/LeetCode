package com.yahoo.jason.leetcode;

import java.util.Arrays;

/**
 * Created by hchang on 5/25/16.
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            int max = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }

        int result = 0;
        for (int num : dp) {
            result = Math.max(num, result);
        }
        return result + 1;
    }

    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
