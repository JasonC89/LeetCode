package leetcode.stars;

import com.yahoo.jason.leetcode.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jason on 6/12/16.
 * Meeting Rooms II
 *
 * Given an array of meeting time intervals
 * consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the
 * minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.
 */
public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

        int result = 0;
        Queue<Integer> heap = new PriorityQueue();
        heap.offer(Integer.MAX_VALUE);
        for (Interval interval : intervals) {
            if (heap.peek() <= interval.start) {
                heap.poll();
                heap.offer(interval.end);
            } else {
                heap.offer(interval.end);
                result++;
            }
        }
        return result;
    }
}
