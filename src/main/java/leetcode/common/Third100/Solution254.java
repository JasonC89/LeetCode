package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/3/16.
 * Factor Combinations
 *
 * Numbers can be regarded as product of its factors. For example,

 8 = 2 x 2 x 2;
 = 2 x 4.
 Write a function that takes an integer n and return all possible combinations of its factors.

 Note:
 You may assume that n is always positive.
 Factors should be greater than 1 and less than n.
 Examples:
 input: 1
 output:
 []
 input: 37
 output:
 []
 input: 12
 output:
 [
 [2, 6],
 [2, 2, 3],
 [3, 4]
 ]
 input: 32
 output:
 [
 [2, 16],
 [2, 2, 8],
 [2, 2, 2, 4],
 [2, 2, 2, 2, 2],
 [2, 4, 4],
 [4, 8]
 ]
 */
public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, n, 2);
        result.remove(result.size()-1);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int start) {
        if (n == 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(result, list, n/i, i);
                list.remove(list.size()-1);
            }
        }
    }
}
