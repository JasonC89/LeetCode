package leetcode.common.First100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/22/16.
 * Combination Sum
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        helper(candidates, target, 0, new ArrayList(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList();
            tmp.addAll(list);
            result.add(tmp);
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        list.add(candidates[index]);
        helper(candidates, target-candidates[index], index, list, result);
        list.remove(list.size()-1);
        helper(candidates, target, index+1, list, result);
    }
}
