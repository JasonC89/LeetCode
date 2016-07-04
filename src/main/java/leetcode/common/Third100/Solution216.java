package leetcode.common.Third100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 7/2/16.
 * Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, k, n, list, result);
        return result;
    }

    private void dfs(int start, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList(list));
            return ;
        }
        if (n < 0) return;
        for (int i = start; i < 10; i++){
            list.add(i);
            dfs(i+1, k, n - i, list, result);
            list.remove(list.size()-1);
        }
    }
}
