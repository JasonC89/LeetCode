package leetcode.stars;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hchang on 6/8/16.
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class Solution128 {
    private int[] parents;
    private int[] ranking;

    public int longestConsecutive(int[] nums) {
        parents = new int[nums.length];
        ranking = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parents[i] = i;
            ranking[i] = 1;
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                if (map.containsKey(nums[i] - 1)) {
                    union(i, map.get(nums[i] - 1));
                }
                if (map.containsKey(nums[i] + 1)) {
                    union(i, map.get(nums[i] + 1));
                }
                map.put(nums[i], i);
            }
        }

        int result = 0;
        for (int rank : ranking) {
            result = Math.max(result, rank);
        }
        return result;
    }

    private int find(int index) {
        while(index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    private boolean union(int i, int j) {
        int parent1 = find(i);
        int parent2 = find(j);
        if (parent1 == parent2) {
            return false;
        }
        if (ranking[parent1] >= ranking[parent2]) {
            parents[parent2] = parent1;
            ranking[parent1] += ranking[parent2];
        } else {
            parents[parent1] = parent2;
            ranking[parent2] += ranking[parent1];
        }
        return true;
    }
}
