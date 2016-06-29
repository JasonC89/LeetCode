package leetcode.common.First100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason on 6/25/16.
 * Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        helper(nums, 0, new ArrayList(), result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
