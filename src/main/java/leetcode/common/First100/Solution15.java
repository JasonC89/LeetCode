package leetcode.common.First100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hchang on 6/21/16.
 * 3Sum
 *
 * Given an array S of n integers, are there elements a, b, c
 * in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length - 2;) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while(left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                }
                if (nums[left] + nums[right] < target) {
                    left++;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                } else {
                    right--;
                    while(left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }

            i++;
            while(i < nums.length-2 && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return result;
    }
}
