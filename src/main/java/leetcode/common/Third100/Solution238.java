package leetcode.common.Third100;

/**
 * Created by Jason on 7/2/16.
 * Product of Array Except Self
 *
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else {
                total *= num;
            }
        }
        int[] result = new int[nums.length];
        if (zero > 1) {
            return result;
        }
        for (int i = 0; i < result.length; i++) {
            if (zero == 1) {
                if (nums[i] == 0) {
                    result[i] = total;
                }
            } else {
                result[i] = total / nums[i];
            }
        }
        return result;
    }
}
