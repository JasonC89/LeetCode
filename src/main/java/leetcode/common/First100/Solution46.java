package leetcode.common.First100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/23/16.
 * Permutations
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> candidates = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        for (int num : nums) {
            candidates.add(num);
        }
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
            list.add(current);
            nums.remove(i);
            helper(nums, list, result);
            nums.add(i, current);
            list.remove(list.size()-1);
        }
    }
}
