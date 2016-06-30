package leetcode.common.First100;

import com.yahoo.jason.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hchang on 6/23/16.
 * Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        List<Interval> result = new ArrayList();
        boolean added = false;
        for (Interval interval : intervals) {
            if (interval.end < start) {
                result.add(interval);
            } else if (interval.start > end) {
                if (!added) {
                    result.add(new Interval(start, end));
                    added = true;
                }
                result.add(interval);
            } else {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
        }
        if (!added) {
            result.add(new Interval(start, end));
        }
        return result;
    }
}
