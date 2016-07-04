package leetcode.common.Third100;

import com.yahoo.jason.leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Jason on 7/2/16.
 * Meeting Rooms
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.
 */
public class Solution252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1].end > intervals[i].start) {
                return false;
            }
        }
        return true;
    }
}
