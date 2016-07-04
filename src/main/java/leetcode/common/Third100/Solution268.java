package leetcode.common.Third100;

/**
 * Created by Jason on 7/3/16.
 * Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int result = 0;
        int i = 0;
        while (i < nums.length) {
            result ^= i;
            result ^= nums[i];
            i++;
        }
        result ^= i;
        return result;
    }
}
