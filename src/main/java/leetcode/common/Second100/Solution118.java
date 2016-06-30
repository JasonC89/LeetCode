package leetcode.common.Second100;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 6/26/16.
 * Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                List<Integer> list = new ArrayList();
                list.add(1);
                result.add(list);
            } else if (i == 2) {
                List<Integer> list = new ArrayList();
                list.add(1);
                list.add(1);
                result.add(list);
            } else {
                List<Integer> list = new ArrayList();
                list.add(1);
                for(int j = 0; j < result.get(i-2).size()-1; j++) {
                    list.add(result.get(i-2).get(j) + result.get(i-2).get(j+1));
                }
                list.add(1);
                result.add(list);
            }
        }
        return result;
    }
}
