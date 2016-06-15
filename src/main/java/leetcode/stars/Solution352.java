package leetcode.stars;

import com.yahoo.jason.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by Jason on 6/14/16.
 * Data Stream as Disjoint Intervals
 *
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

 For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

 [1, 1]
 [1, 1], [3, 3]
 [1, 1], [3, 3], [7, 7]
 [1, 3], [7, 7]
 [1, 3], [6, 7]
 Follow up:
 What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */
public class Solution352 {

    TreeMap<Integer, Interval> map;

    public Solution352() {
        map = new TreeMap();
    }

    public void addNum(int val) {
        if(map.containsKey(val)) {
            return;
        }
        Integer low = map.lowerKey(val);
        Integer high = map.higherKey(val);
        if(low != null && high != null && map.get(low).end + 1 == val && high == val + 1) {
            map.get(low).end = map.get(high).end;
            map.remove(high);
        } else if(low != null && map.get(low).end + 1 >= val) {
            map.get(low).end = Math.max(map.get(low).end, val);
        } else if(high != null && high == val + 1) {
            map.put(val, new Interval(val, map.get(high).end));
            map.remove(high);
        } else {
            map.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
