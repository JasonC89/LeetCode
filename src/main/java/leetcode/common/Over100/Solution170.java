package leetcode.common.Over100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 6/28/16.
 * Two Sum III - Data structure design
 *
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false
 */
public class Solution170 {
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap();

    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, map.get(number)+1);
        }
    }

    public boolean find(int value) {
        for (int first : list) {
            int second = value - first;
            if (first == second && map.get(first) >= 2) {
                return true;
            } else if (first != second && map.containsKey(second)){
                return true;
            }
        }
        return false;
    }
}
