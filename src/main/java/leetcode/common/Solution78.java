package leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/25/16.
 * Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        helper(nums, 0, list, result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}
