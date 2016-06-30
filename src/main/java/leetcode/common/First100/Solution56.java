package leetcode.common.First100;

import com.yahoo.jason.leetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hchang on 6/23/16.
 * Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].
 */
public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) {
            return result;
        }
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (end < intervals.get(i).start) {
                result.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
