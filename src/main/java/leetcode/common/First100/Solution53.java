package leetcode.common.First100;

/**
 * Created by hchang on 6/23/16.
 * Maximum Subarray
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int current = 0;
        for (int num : nums) {
            current += num;
            result = Math.max(current, result);
            if (current < 0) {
                current = 0;
            }
        }
        return result;
    }
}
