package leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason on 6/21/16.
 * 4Sum
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length - 3;) {
            for (int j = i + 1; j < nums.length - 2;) {
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> tmp = new ArrayList();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        result.add(tmp);
                    }
                    if (sum < target) {
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
                j++;
                while(j < nums.length-2 && nums[j] == nums[j-1]) {
                    j++;
                }
            }
            i++;
            while(i < nums.length-3 && nums[i] == nums[i-1]) {
                i++;
            }
        }
        return result;
    }
}
