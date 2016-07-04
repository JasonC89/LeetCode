package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.


 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            right++;
            while(sum >= s) {
                result = Math.min(result, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }
}
