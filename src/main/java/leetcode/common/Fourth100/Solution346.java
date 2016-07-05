package leetcode.common.Fourth100;

import java.util.ArrayDeque;

/**
 * Created by Jason on 7/4/16.
 * Moving Average from Data Stream
 *
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 For example,
 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class Solution346 {

    private int size;
    private double sum;
    private ArrayDeque<Integer> queue;

    /** Initialize your data structure here. */
    public Solution346(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
