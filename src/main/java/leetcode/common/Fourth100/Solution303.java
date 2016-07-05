package leetcode.common.Fourth100;

/**
 * Created by Jason on 7/3/16.
 * Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between
 * indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */
public class Solution303 {

    int[] dp;

    public Solution303(int[] nums) {
        dp = new int[nums.length+1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i+1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1] - dp[i];
    }
}
