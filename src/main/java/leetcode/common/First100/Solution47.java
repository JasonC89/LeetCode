package leetcode.common.First100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hchang on 6/23/16.
 * Permutations II
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> candidates = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        for (int num : nums) {
            candidates.add(num);
        }
        Collections.sort(candidates);
        helper(candidates, new ArrayList(), result);
        return result;
    }

    private void helper(List<Integer> nums, List<Integer> list, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            if (i > 0 && current == nums.get(i-1)) {
                continue;
            }
            list.add(current);
            nums.remove(i);
            helper(nums, list, result);
            nums.add(i, current);
            list.remove(list.size()-1);
        }
    }
}
