package leetcode.common.First100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/25/16.
 * Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> candidates = new ArrayList();
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
        }
        List<Integer> list = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        combine(result, candidates, list, 0, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> candidates, List<Integer> list, int start, int k) {
        if (k == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            int current = candidates.get(i);
            list.add(current);
            combine(result, candidates, list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}
