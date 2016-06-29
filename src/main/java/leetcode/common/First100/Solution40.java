package leetcode.common.First100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jason on 6/22/16.
 * Combination Sum II
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
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
        helper(candidates, target-candidates[index], index+1, list, result);
        list.remove(list.size()-1);
        int current = candidates[index];
        while(index < candidates.length && candidates[index] == current) {
            index++;
        }
        helper(candidates, target, index, list, result);
    }
}
