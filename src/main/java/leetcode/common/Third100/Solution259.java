package leetcode.common.Third100;

import java.util.Arrays;

/**
 * Created by Jason on 7/3/16.
 * 3Sum Smaller
 *
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

 For example, given nums = [-2, 0, 1, 3], and target = 2.

 Return 2. Because there are two triplets which sums are less than 2:

 [-2, 0, 1]
 [-2, 0, 3]
 Follow up:
 Could you solve it in O(n2) runtime?
 */
public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int sum = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] < sum) {
                    result += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
