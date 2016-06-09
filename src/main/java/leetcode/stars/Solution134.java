package leetcode.stars;

/**
 * Created by Jason on 6/8/16.
 * Gas Station
 *
 * There are N gas stations along a circular route,
 * where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it
 costs cost[i] of gas to travel from station i to
 its next station (i+1). You begin the journey with
 an empty tank at one of the gas stations.

 Return the starting gas station's index if you
 can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if (current < 0) {
                current = 0;
                start = i + 1;
            }
        }
        if (total < 0) {
            return -1;
        }
        return start;
    }
}
