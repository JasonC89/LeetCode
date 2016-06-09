package com.yahoo.jason.leetcode;

import java.util.TreeSet;

/**
 * Created by hchang on 6/3/16.
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that the difference
 * between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t);
            Integer ceil = set.ceiling(nums[i] - t);
            if ((floor != null && Math.abs(floor - nums[i]) <= t)
                || (ceil != null && Math.abs(ceil - nums[i]) <= t)) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() >= k) {
                set.remove(nums[i - k + 1]);
            }
        }
        return false;
    }
}
