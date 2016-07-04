package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * House Robber II
 *
 * Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] robFirst = new int[n+1];
        int[] notFirst = new int[n+1];
        robFirst[1] = nums[0];
        notFirst[2] = nums[1];
        for (int i = 2; i < n; i++) {
            robFirst[i] = Math.max(robFirst[i-1], robFirst[i-2] + nums[i-1]);
            notFirst[i+1] = Math.max(notFirst[i], notFirst[i-1] + nums[i]);
        }
        int result = 0;
        for (int i = 0; i < n+1; i++) {
            result = Math.max(result, robFirst[i]);
            result = Math.max(result, notFirst[i]);
        }
        return result;
    }
}
