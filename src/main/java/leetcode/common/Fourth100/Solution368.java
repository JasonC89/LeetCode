package leetcode.common.Fourth100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason on 7/5/16.
 * Largest Divisible Subset
 * <p>
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example 1:
 * <p>
 * nums: [1,2,3]
 * <p>
 * Result: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 * <p>
 * nums: [1,2,4,8]
 * <p>
 * Result: [1,2,4,8]
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        } else {
            Arrays.sort(nums);
            int[] parent = new int[nums.length];
            int[] count = new int[nums.length];
            int max = 0, maxind = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] % nums[i] == 0 && count[i] < 1 + count[j]) {
                        count[i] = 1 + count[j];
                        parent[i] = j;
                        if (count[i] > max) {
                            max = count[i];
                            maxind = i;
                        }
                    }
                }
            }
            for (int i = 0; i < max; i++) {
                result.add(nums[maxind]);
                maxind = parent[maxind];
            }
            return result;
        }
    }
}
